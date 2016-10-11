package top.cynara.cwechat.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import top.cynara.cwechat.entitiy.RegisterUser;
import top.cynara.cwechat.service.RegisterUserService;
import top.cynara.cwechat.utils.HashUtil;
/**
 * @ClassName UserController 
 * @Description 用于用户登录注册 
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月10日 下午5:10:02 
 * @version V1.0
 */
@Controller
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private RegisterUserService service;
	/**
	 * @Title registerPost 
	 * @Description 用于接收用户注册的数据 检查字段是否符合 并给予提示
	 * @param user 从页面传过来封装的user用户
	 * @param result 有可能会发生的异常  为了错误显示 表单验证
	 * @param map 用于数据回显
	 * @param session 用户获取验证码
	 * @param randomcode 网页传递过来的验证码
	 * @return 验证通过返回到登录页面  不通过到注册页面 
	 * @author Cynara-remix
	 * @Date 2016年10月10日 下午5:10:17
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPost(@Valid RegisterUser user,BindingResult result
			,Map<String, Object> map,HttpSession session
			,@RequestParam("randomcode")String randomcode){
		String validateCode = (String) session.getAttribute("validateCode");
		//判断验证码是否一致
		if(!validateCode.equals(randomcode)){
			log.debug(user.getUsername()+":用户注册验证码填写错误");
			//为了在页面使用if判断  如果出错此值不为空就能显示国际化的提示消息
			map.put("randomCode", "!");
			return "register";
		}
		//判断是否有错误
		if(result.getAllErrors().size()!=0){
			for(FieldError error : result.getFieldErrors()){
				log.debug(error.getField()+error.getDefaultMessage());
				map.put(error.getField(), error.getDefaultMessage());
			}
			map.put("user", user);
			return "register";
		}
		RegisterUser rUser = service.findByUserCode(user.getUsercode());
		if(rUser!=null){
			log.debug("注册用户已经存在");
			return "register";
		}
		user.setId(UUID.randomUUID().toString());
		user.setPassword(HashUtil.getMd5Hash(user.getPassword(), "cynara"));
		user.setLocked("0");
		user.setRegisterTime(new Date());
		user.setSalt("cynara");
		service.insert(user);
		log.debug(user.getUsername()+":注册成功");
		return "login";
		
		
	}
	/**
	 * @Title registerGet 
	 * @Description 用户GET请求注册页面
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月10日 下午5:19:13
	 */
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerGet(){
		log.debug("注册页面被请求");
		return "register";
	}
	/**
	 * @Title login 
	 * @Description 用于配合shiro处理用户登录 发生什么错误时什么原因是固定的
	 * @param request 用户将错误信息输出到页面给用户提示
	 * @param session 用于从session中读取错误字段   Shiro认证出错会将错误信息放到sessioin中名称为shiroLoginFailure
	 * @return 如果该loggin方法被执行  就说明发生来错误 只能跳转到注册页面
	 * @throws Exception       
	 * @author Cynara-remix
	 * @Date 2016年10月10日 下午5:19:30
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpSession session) throws Exception {
		// 如果登录失败 从request中获取认证信息shiroLoginFailure 就是异常类的全类名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		log.debug("用户认证出现错误："+exceptionClassName);
		if(exceptionClassName!=null){
			if(UnknownAccountException.class.getName().equals(exceptionClassName)){
				log.debug("用户认证错误：账号不存在!");
				request.setAttribute("errorMessage", "账号不存在!");
			}else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
				log.debug("用户认证错误：密码错误!");
				request.setAttribute("errorMessage", "密码错误!");
			}else if("randomcodeError".equals(exceptionClassName)){
				log.debug("用户认证错误：验证码错误!");
				request.setAttribute("errorMessage", "验证码错误!");
			}else {
				log.debug("用户认证错误：未知错误!");
				request.setAttribute("errorMessage", "未知错误!");
			}
		}
		//此方法不处理登录成功 shiro认证成功会自动跳转到上一个请求路径
		// 认证失败转向login
		return "login";
	}
}
