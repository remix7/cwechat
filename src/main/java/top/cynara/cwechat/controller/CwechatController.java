package top.cynara.cwechat.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.cynara.cwechat.entitiy.ActiveUser;
import top.cynara.cwechat.entitiy.CwechatAccess;
import top.cynara.cwechat.service.CwechatAccessService;
import top.cynara.cwechat.service.ReceiveWechatMessageService;
import top.cynara.cwechat.service.ReplayWechatMessageService;
import top.cynara.cwechat.utils.ReceiveXmlToMessageUtil;

@Controller
public class CwechatController {
	@Autowired
	private CwechatAccessService service;
	@Autowired
	private ReceiveWechatMessageService messageService;
	@Autowired
	private ReplayWechatMessageService replayWechatMessageService;
	
	@ResponseBody()
	@RequestMapping(value="/accessWechat",method=RequestMethod.POST)
	public void requestRrocessing(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			Map<String, String> xmls = ReceiveXmlToMessageUtil.parseXml(request, response);
			String sendMessage = ReceiveXmlToMessageUtil.parseMessage(xmls,messageService,replayWechatMessageService);
			response.getWriter().write(sendMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(value="/addAccess",method=RequestMethod.POST)
	public String addAccess(@Valid CwechatAccess access,BindingResult result
			,Map<String, Object> map,HttpSession session
			,@RequestParam("randomcode")String randomcode){
		String validateCode = (String) session.getAttribute("validateCode");
		//判断验证码是否一致
		if(!validateCode.equals(randomcode)){
			//为了在页面使用if判断  如果出错此值不为空就能显示国际化的提示消息
			map.put("randomCode", "!");
			map.put("access", access);
			return "addAccess";
		}
		//判断是否有错误
		if(result.getAllErrors().size()!=0){
			for(FieldError error : result.getFieldErrors()){
				map.put(error.getField(), error.getDefaultMessage());
			}
			map.put("access", access);
			return "addAccess";
		}
		CwechatAccess ca = service.findByAppId(access.getAppid());
		if(ca!=null){
			return "addAccess";
		}
		access.setAccessDate(new Date());
		access.setId(UUID.randomUUID().toString());
		access.setIsTrue("1");
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		access.setUserId(user.getUserid());
		service.insert(access);
		return "redirect:viewAccess";
	}
	@RequestMapping(value="/addAccess",method=RequestMethod.GET)
	public String addAccessUI(){
		return "addAccess";
	}
	
	
	@RequestMapping("/viewAccess")
	public String viewAccess(Map<String, Object> map,HttpSession session){
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		List<CwechatAccess> cList = service.findAllByUserId(user.getUserid());
		map.put("cList", cList);
		return "viewaccess";
	}
	/**
	 * 
	 * @Title accessWechat 
	 * @Description 用于用户在微信端连接服务器 
	 * @param request
	 * @param response
	 * @throws Exception       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午3:53:40
	 */
	@ResponseBody()
	@RequestMapping(value="/accessWechat",method=RequestMethod.GET)
	public void accessWechat(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String token = "cynara";
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//微信加密签名
		String signature = request.getParameter("signature");
		//时间戳
		String timestamp = request.getParameter("timestamp");
		//随机数
		String nonce = request.getParameter("nonce");
		//随机字符串
		String echostr = request.getParameter("echostr");
		//将要排序加密的数据放入集合
		List<String> sList = new ArrayList<String>();
		sList.add(token);
		sList.add(timestamp);
		sList.add(nonce);
		//将要sha1加密比对的数据  进行汉字拼音排序
		Collections.sort(sList, new SpellComparator());
		//排序后的数据
		String wxstr = sList.get(0)+sList.get(1)+sList.get(2);
		//比对
		if(DigestUtils.sha1Hex(wxstr).equals(signature.trim())){
			//如果比对成功往微信写echostr
			response.getWriter().write(echostr);
		}
		System.out.println(DigestUtils.sha1Hex(wxstr));
	}
	/**
	 * 
	 * @ClassName SpellComparator 
	 * @Description 汉字拼音排序比较器 
	 * @author Cynara-remix http://cynara.top
	 * E-mail remix7@live.cn 
	 * @date 2016年10月11日 下午3:53:22 
	 * @version V1.0
	 */
	class SpellComparator implements Comparator<Object>{

		public int compare(Object o1, Object o2) {
			try {
				String s1 = new String(o1.toString().getBytes("GB2312"),"ISO-8859-1");
				String s2 = new String(o2.toString().getBytes("GB2312"),"ISO-8859-1");
				return s1.compareTo(s2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		
	}
}
