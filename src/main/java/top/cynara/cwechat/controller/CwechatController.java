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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.cynara.cwechat.entitiy.ActiveUser;
import top.cynara.cwechat.entitiy.CwechatAccess;
import top.cynara.cwechat.entitiy.CwechatFollowUser;
import top.cynara.cwechat.entitiy.ReceiveWechatMessage;
import top.cynara.cwechat.entitiy.ReplayWechatMessage;
import top.cynara.cwechat.service.CwechatAccessService;
import top.cynara.cwechat.service.CwechatFollowUserService;
import top.cynara.cwechat.service.ReceiveWechatMessageService;
import top.cynara.cwechat.service.ReplayWechatMessageService;
import top.cynara.cwechat.utils.CwechatConnectionUtil;
import top.cynara.cwechat.utils.ReceiveXmlToMessageUtil;
/**
 * @ClassName CwechatController 
 * @Description 处理用户关于微信的请求
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月18日 下午10:24:07 
 * @version V1.0
 */
@Controller
public class CwechatController {
	private Logger log = Logger.getLogger(CwechatController.class);
	@Autowired
	private CwechatAccessService service;
	@Autowired
	private ReceiveWechatMessageService messageService;
	@Autowired
	private ReplayWechatMessageService replayWechatMessageService;
	@Autowired
	private CwechatFollowUserService cwechatFollowUserService;
	/**
	 * @Title followmeById 
	 * @Description 获取该用户的详细信息
	 * @param openId
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月16日 下午9:56:05
	 */
	@RequestMapping("/followme/{openId}")
	public String followmeById(@PathVariable("openId")String openId,HttpSession session,
			Map<String, Object> map){
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		CwechatAccess access = service.findAllByUserId(user.getUserid()).get(0);
		Map<String, String> resMap = CwechatConnectionUtil.findUserByOpenId(access.getAppid(), access.getSecret(), openId);
		log.debug("<!----------用户："+user.getUsername()+"获取"+openId+" 详细信息成功！----------!>");
		map.put("rMap", resMap);
		return "followview";
		
	}
	/**
	 * @Title followme 
	 * @Description 获取用户关注列表
	 * @param map
	 * @param session
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月16日 下午9:54:31
	 */
	@RequestMapping("/followme")
	public String followme(Map<String, Object> map,HttpSession session){
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		CwechatAccess access = service.findAllByUserId(user.getUserid()).get(0);
		List<CwechatFollowUser> cfuList = cwechatFollowUserService.findAllByAccessId(access.getId());
		map.put("cList", cfuList);
		log.debug("<!----------用户："+user.getUsername()+"获取微信关注列表成功！长度为："+cfuList.size()+"----------!>");
		return "followme";
	}
	/**
	 * @Title message 
	 * @Description 查看消息详情
	 * @param 消息id
	 * @param map
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月15日 下午9:02:58
	 */
	@RequestMapping("/message/{id}")
	public String message(@PathVariable("id")String id,Map<String, Object> map){
		ReceiveWechatMessage receiveWechatMessage = messageService.findById(id);
		ReplayWechatMessage replayWechatMessage = replayWechatMessageService.findByReceiveId(receiveWechatMessage.getId());
		map.put("recMessage",receiveWechatMessage);
		map.put("repMessage", replayWechatMessage);
		log.debug("<!----------id为："+id+"的消息被查看----------!>");
		return "message";
	}
	
	/**
	 * @Title messageList 
	 * @Description 用户接入微信收到的消息列表
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月14日 下午10:14:53
	 */
	@RequestMapping("/messageList")
	public String messageList(HttpSession session,Map<String, Object> map){
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		List<CwechatAccess> accessList = service.findAllByUserId(user.getUserid());
		List<ReceiveWechatMessage> receiveWechatMessagesList = new ArrayList<ReceiveWechatMessage>();
		for (CwechatAccess cwechatAccess : accessList) {
			List<ReceiveWechatMessage> messages = messageService.findAllByToUserName(cwechatAccess.getOriginalId());
			receiveWechatMessagesList.addAll(messages);
		}
		log.debug("<!----------用户："+user.getUsername()+" 查看微信收到的消息---------->");
		map.put("rwmList", receiveWechatMessagesList);
		return "messageList";
	}
	/**
	 * @Title requestRrocessing 
	 * @Description 微信消息接入接口
	 * @param request
	 * @param response
	 * @throws Exception       
	 * @author Cynara-remix
	 * @Date 2016年10月15日 下午9:04:01
	 */
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
			log.debug("<!-----------微信发来消息服务器处理异常"+e+"----------!>");
		}
		log.debug("<!---------微信发来消息服务器处理正常----------!>");
	}
	
	/**
	 * @Title addAccess 
	 * @Description 添加接入的微信
	 * @param access
	 * @param result
	 * @param map
	 * @param session
	 * @param randomcode
	 * @author Cynara-remix
	 * @Date 2016年10月15日 下午9:05:10
	 */
	@RequestMapping(value="/addAccess",method=RequestMethod.POST)
	public String addAccess(@Valid CwechatAccess access,BindingResult result
			,Map<String, Object> map,HttpSession session
			,@RequestParam("randomcode")String randomcode){
		String validateCode = (String) session.getAttribute("validateCode");
		//判断验证码是否一致
		if(!validateCode.equals(randomcode)){
			//为了在页面使用if判断  如果出错此值不为空就能显示国际化的提示消息
			log.error("<!----------微信接入信息验证码出错！---------->");
			map.put("randomCode", "!");
			map.put("access", access);
			return "addAccess";
		}
		//判断是否有错误
		if(result.getAllErrors().size()!=0){
			for(FieldError error : result.getFieldErrors()){
				map.put(error.getField(), error.getDefaultMessage());
				log.error("<!----------微信接入信息字段验证出错！"+error.getField()+" : "+error.getDefaultMessage()+"----------!>");
			}
			map.put("access", access);
			return "addAccess";
		}
		CwechatAccess ca = service.findByAppId(access.getAppid());
		if(ca!=null){
			log.error("<!----------微信接入信息appid 重复！----------!>");
			return "addAccess";
		}
		access.setAccessDate(new Date());
		access.setId(UUID.randomUUID().toString());
		access.setIsTrue("1");
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		access.setUserId(user.getUserid());
		service.insert(access);
		log.info("<!----------微信接入成功："+user.getUsername()+" --"+ca.getAppid()+"----------!>");
		return "redirect:viewAccess";
	}
	/**
	 * @Title addAccessUI 
	 * @Description 转向添加接入微信的界面 
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月15日 下午9:05:49
	 */
	@RequestMapping(value="/addAccess",method=RequestMethod.GET)
	public String addAccessUI(){
		log.info("<!----------转向微信接入界面成功！----------!>");
		return "addAccess";
	}
	/**
	 * @Title viewAccess 
	 * @Description 查看对应用户的微信接入详情
	 * @param map
	 * @param session
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月15日 下午9:06:16
	 */
	@RequestMapping("/viewAccess")
	public String viewAccess(Map<String, Object> map,HttpSession session){
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		List<CwechatAccess> cList = service.findAllByUserId(user.getUserid());
		map.put("cList", cList);
		log.info("<!----------User:"+user.getUsername()+"-->查看微信接入情况----------!>");
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
			log.info("<!----------微信接入服务器成功"+echostr+"----------!>");
		}else{
			log.info("<!----------微信接入服务器失败"+echostr+"----------!>");
		}
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
