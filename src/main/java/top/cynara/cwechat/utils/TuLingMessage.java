package top.cynara.cwechat.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;
import top.cynara.cwechat.constant.MessageType;
import top.cynara.cwechat.entitiy.ReceiveWechatMessage;
import top.cynara.cwechat.entitiy.ReplayWechatMessage;
import top.cynara.cwechat.message.common.replay.ReplayImageTextMessage;
import top.cynara.cwechat.message.common.replay.ReplayTextMessage;
import top.cynara.cwechat.service.ReplayWechatMessageService;

/**
 * @ClassName TuLingMessage
 * @Description 微信消息使用图灵机器人回复
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月13日 下午5:54:23
 * @version V1.0
 */
public class TuLingMessage {
	private static String API_URL = "http://www.tuling123.com/openapi/api";
	private static String API_KEY = "30f1786d28abc487c901f9352999820c";
	private static String SECRET = "924dc30613c8e02e";

	public static String getTuLingMessage(ReceiveWechatMessage receiveWechatMessage,
			ReplayWechatMessageService replayWechatMessageService) {
		try {
			URL url = new URL(API_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置连接属性
			conn.setDoOutput(true); // 使用url输出
			conn.setDoInput(true); // 使用url进行输入
			conn.setUseCaches(false); // 忽略缓存
			JSONObject jo = new JSONObject();
			jo.element("key", API_KEY);
			jo.element("info", receiveWechatMessage.getContext());
			jo.element("userid", receiveWechatMessage.getFromUserName());
			System.out.println(jo.toString());
			// 设置请求属性
			conn.setRequestProperty("Content-length", "" + jo.toString().getBytes().length);
			conn.setRequestProperty("Content-Type", "application/octet-stream");
			conn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
			conn.setRequestProperty("Charset", "UTF-8");
			// 构建输出流 写数据
			OutputStream out = conn.getOutputStream();
			out.write(jo.toString().getBytes());
			out.close();
			// 获取输出流
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			return getReplayMessage(br.readLine(), receiveWechatMessage, replayWechatMessageService);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回null
		return "";
	}

	/**
	 * 判断json是否包含一个key jo.containsKey("url")
	 * 
	 * @Title getMessage
	 * @Description 读取到接口返回的数据 构建用于微信返回的数据
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月13日 下午9:37:24
	 */
	public static String getReplayMessage(String line, ReceiveWechatMessage receiveWechatMessage,
			ReplayWechatMessageService replayWechatMessageService) {
		JSONObject jo = JSONObject.fromObject(line);
		System.out.println(jo.toString());
		ReplayWechatMessage wechatMessage = new ReplayWechatMessage();
		wechatMessage.setId(UUID.randomUUID().toString());
		wechatMessage.setCreateTime(new Date().getTime() + "");
		wechatMessage.setFromUserName(receiveWechatMessage.getToUserName());
		wechatMessage.setToUserName(receiveWechatMessage.getFromUserName());
		wechatMessage.setUserId(receiveWechatMessage.getId());
		// 文本消息
		if (!jo.containsKey("url") && !jo.containsKey("name") && !jo.containsKey("list") && !jo.containsKey("song")
				&& !jo.containsKey("author ")) {
			String text = jo.getString("text");
			ReplayTextMessage message = new ReplayTextMessage();
			message.setContext(text);
			message.setCreateTime(new Date().getTime() + "");
			message.setFromUserName(receiveWechatMessage.getToUserName());
			message.setToUserName(receiveWechatMessage.getFromUserName());
			// 将回复的东西保存起来
			wechatMessage.setContext(text);
			wechatMessage.setMsgType(MessageType.TEXT_MESSAGE);
			replayWechatMessageService.insert(wechatMessage);
			return ReplayMessageUtil.sendTextMessage(message);
			// 单图文消息
		} else if (jo.containsKey("url")) {
			String text = jo.getString("text");
			String url = jo.getString("url");
			ReplayImageTextMessage message = new ReplayImageTextMessage();
			message.setArticleCount("1");
			message.setCreateTime(new Date().getTime() + "");
			message.setFromUserName(receiveWechatMessage.getToUserName());
			message.setToUserName(receiveWechatMessage.getFromUserName());
			message.setTitle(Arrays.asList(text));
			message.setUrl(Arrays.asList(url));
			// 将回复的东西保存起来
			wechatMessage.setArticleCount("1");
			wechatMessage.setTitle(text);
			wechatMessage.setUrl(url);
			wechatMessage.setMsgType(MessageType.IMAGE_TEXT_MESSAGE);
			replayWechatMessageService.insert(wechatMessage);
			return ReplayMessageUtil.sendImageTextMessage(message);
			// 多图文消息 新闻
		} else if (jo.containsKey("list") && "302000".equals(jo.getString("code"))) {
			List<Map<String, String>> lmp = (List<Map<String, String>>) jo.get("list");
			ReplayImageTextMessage message = new ReplayImageTextMessage();
			message.setArticleCount((lmp.size() >= 9 ? 10 : lmp.size()) + "");
			message.setCreateTime(new Date().getTime() + "");
			message.setFromUserName(receiveWechatMessage.getToUserName());
			message.setToUserName(receiveWechatMessage.getFromUserName());
			List<String> title = new ArrayList<String>();
			List<String> description = new ArrayList<String>();
			List<String> picUrl = new ArrayList<String>();
			List<String> url = new ArrayList<String>();
			for (int i = 0; i < (lmp.size() >= 9 ? 9 : lmp.size()); i++) {
				title.add(lmp.get(i).get("article"));
				description.add(lmp.get(i).get("source"));
				picUrl.add(lmp.get(i).get("icon"));
				url.add(lmp.get(i).get("detailurl"));
			}
			message.setPicUrl(picUrl);
			message.setTitle(title);
			message.setDescription(description);
			message.setUrl(url);
			wechatMessage.setArticleCount((lmp.size() >= 9 ? 10 : lmp.size()) + "");
			wechatMessage.setMsgType(MessageType.IMAGE_TEXT_MESSAGE);
			wechatMessage.setTitle(title.toString());
			wechatMessage.setDescription(description.toString());
			wechatMessage.setPicUrl(picUrl.toString());
			wechatMessage.setUrl(url.toString());
			replayWechatMessageService.insert(wechatMessage);
			return ReplayMessageUtil.sendImageTextMessage(message);
			// 多图文消息 菜谱
		} else if (jo.containsKey("list") && "308000".equals(jo.getString("code"))) {
			List<Map<String, String>> lmp = (List<Map<String, String>>) jo.get("list");
			ReplayImageTextMessage message = new ReplayImageTextMessage();
			message.setArticleCount((lmp.size() >= 9 ? 10 : lmp.size()) + "");
			message.setCreateTime(new Date().getTime() + "");
			message.setFromUserName(receiveWechatMessage.getToUserName());
			message.setToUserName(receiveWechatMessage.getFromUserName());
			List<String> title = new ArrayList<String>();
			List<String> description = new ArrayList<String>();
			List<String> picUrl = new ArrayList<String>();
			List<String> url = new ArrayList<String>();
			for (int i = 0; i < (lmp.size() >= 9 ? 10 : lmp.size()); i++) {
				title.add(lmp.get(i).get("name"));
				description.add(lmp.get(i).get("info"));
				picUrl.add(lmp.get(i).get("icon"));
				url.add(lmp.get(i).get("detailurl"));
			}
			message.setPicUrl(picUrl);
			message.setTitle(title);
			message.setDescription(description);
			message.setUrl(url);
			wechatMessage.setArticleCount((lmp.size() >= 9 ? 10 : lmp.size()) + "");
			wechatMessage.setMsgType(MessageType.IMAGE_TEXT_MESSAGE);
			wechatMessage.setTitle(title.toString());
			wechatMessage.setDescription(description.toString());
			wechatMessage.setPicUrl(picUrl.toString());
			wechatMessage.setUrl(url.toString());
			replayWechatMessageService.insert(wechatMessage);
			System.out.println(ReplayMessageUtil.sendImageTextMessage(message));
			return ReplayMessageUtil.sendImageTextMessage(message);
		}
		return "";
	}

}
