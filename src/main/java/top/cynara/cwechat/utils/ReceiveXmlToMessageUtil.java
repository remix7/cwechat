package top.cynara.cwechat.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import top.cynara.cwechat.constant.MessageType;
import top.cynara.cwechat.entitiy.ReceiveWechatMessage;
import top.cynara.cwechat.service.ReceiveWechatMessageService;
import top.cynara.cwechat.service.ReplayWechatMessageService;

/**
 * @ClassName ReceiveXmlToMessageUtil
 * @Description 处理微信请求发过来的xml数据 并保存到数据库
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午5:11:08
 * @version V1.0
 */
public class ReceiveXmlToMessageUtil {
	/**
	 * 
	 * @Title parseXml
	 * @Description 将用户的xml消息提取成map key value 类型
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午6:58:05
	 */
	public static Map<String, String> parseXml(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("run parseXml");
		Map<String, String> map = new HashMap<String, String>();
		InputStream in = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document document = reader.read(in);
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		for (Element element : elementList) {
			map.put(element.getName(), element.getText());
		}
		in.close();
		return map;
	}

	/**
	 * @Title parseMessage
	 * @Description 从数据库中查询去消息并返回给用户
	 * @param string
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午9:16:13
	 */
	public static String parseMessage(Map<String, String> map, ReceiveWechatMessageService messageService,
			ReplayWechatMessageService replayWechatMessageService) {
		ReceiveWechatMessage receiveWechatMessage = new ReceiveWechatMessage();
		String type = map.get("MsgType");
		receiveWechatMessage.setMsgType(type);
		receiveWechatMessage.setId(UUID.randomUUID().toString());
		if (MessageType.TEXT_MESSAGE.equals(type)) {
			receiveWechatMessage.setContext(map.get("Content"));
			receiveWechatMessage.setCreateTime(map.get("CreateTime"));
			// 发送方id
			receiveWechatMessage.setFromUserName(map.get("FromUserName"));
			// 开发者账号
			receiveWechatMessage.setToUserName(map.get("ToUserName"));
			receiveWechatMessage.setMsgId(map.get("MsgId"));
			messageService.insert(receiveWechatMessage);
			return TuLingMessage.getTuLingMessage(receiveWechatMessage, replayWechatMessageService);
		} else if (MessageType.IMAGE_MESSAGE.equals(type)) {

		} else if (MessageType.VOICE_MESSAGE.equals(type)) {

		} else if (MessageType.VIDEO_MESSAGE.equals(type)) {

		}
		return null;
	}
}
