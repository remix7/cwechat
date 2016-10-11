package top.cynara.cwechat.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import top.cynara.cwechat.entitiy.ActiveUser;
/**
 * @ClassName IndexPage 
 * @Description 用户访问本应用 锁访问的默认首页
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月10日 下午5:24:05 
 * @version V1.0
 */
@Controller
public class IndexPage {
	private Logger log = Logger.getLogger(IndexPage.class);
	/**
	 * @Title index 
	 * @Description 将认证通过的用户信息 放入到作用域中
	 * @param model 此处作用和map相同
	 * @return 返回真正的index首页
	 * @throws Exception       
	 * @author Cynara-remix
	 * @Date 2016年10月10日 下午5:24:31
	 */
	@RequestMapping("/**/index")
	public String index(HttpSession session)throws Exception{
		//从shiZro的session中取出activeUser
		Subject subject = SecurityUtils.getSubject();
		//取出身份信息
		ActiveUser activeUser =  (ActiveUser) subject.getPrincipal();
		session.setAttribute("activeUser", activeUser);
		log.debug(activeUser.getUsername()+":登录成功！");
		return "index";
	}
}
