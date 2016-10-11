package top.cynara.cwechat.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 
 * @ClassName UserFormAuthenticationFilter
 * @Description 自定义FormAuthenticationFilter 在认证之前校对验证码
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月7日 下午9:07:08
 * @version V1.0
 */
public class UserFormAuthenticationFilter extends FormAuthenticationFilter {
	/**
	 * 用于认证的方法
	 */
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 在这里进行验证码校验
		// session 要把request转为httpServletRequest 才能获取到
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// 取车session中的验证码
		String validateCode = (String) httpServletRequest.getSession().getAttribute("validateCode");
		// 取出页面的验证码
		String randomcode = (String) httpServletRequest.getParameter("randomcode");
		if (randomcode != null && validateCode != null && !randomcode.equalsIgnoreCase(validateCode)) {
			// 如果失败提示验证码错误 通过shiroLoginFailure 设置到request中
			httpServletRequest.setAttribute("shiroLoginFailure", "randomcodeError");
			// 如果验证不通过就返回true 不在校验账号和密码
			return true;
		}
		return super.onAccessDenied(request, response);
	}
}
