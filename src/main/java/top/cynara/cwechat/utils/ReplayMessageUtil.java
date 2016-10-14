package top.cynara.cwechat.utils;

import java.io.Serializable;
import java.util.Date;

import top.cynara.cwechat.constant.MessageType;
import top.cynara.cwechat.message.common.replay.ReplayImageMessage;
import top.cynara.cwechat.message.common.replay.ReplayImageTextMessage;
import top.cynara.cwechat.message.common.replay.ReplayMusicMessage;
import top.cynara.cwechat.message.common.replay.ReplayTextMessage;
import top.cynara.cwechat.message.common.replay.ReplayVideoMessage;
import top.cynara.cwechat.message.common.replay.ReplayVoiceMessage;

/**
 * @ClassName ReplayMessageUtil
 * @Description 构建回复消息
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午8:06:32
 * @version V1.0
 */
public class ReplayMessageUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[news]]></MsgType>
	 * <ArticleCount>2</ArticleCount>
	 * <Articles> <item> <Title><![CDATA[title1]]></Title>
	 * <Description><![CDATA[description1]]></Description>
	 * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
	 * <item> <Title><![CDATA[title]]></Title>
	 * <Description><![CDATA[description]]></Description>
	 * <PicUrl><![CDATA[picurl]]></PicUrl>
	 * <Url><![CDATA[url]]></Url> </item> </Articles> </xml>
	 * 
	 * @Title sendImageTextMessage
	 * @Description 回复图文消息
	 * @param message
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午8:38:06
	 */
	public static String sendImageTextMessage(ReplayImageTextMessage message) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
		sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
		sb.append("<MsgType><![CDATA[" + MessageType.IMAGE_TEXT_MESSAGE + "]]></MsgType>");
		sb.append("<ArticleCount>" + message.getArticleCount() + "</ArticleCount>");
		sb.append("<Articles> ");
		int len = Integer.parseInt(message.getArticleCount());
		for (int i = 0; i < len; i++) {
			sb.append("<item>");
			if (message.getTitle().size() == len && message.getTitle().get(i) != null
					&& !"".equals(message.getTitle().get(i))) {
				sb.append("<Title><![CDATA[" + message.getTitle().get(i) + "]]></Title>");
			}
			if (message.getDescription().size() == len && message.getDescription().get(i) != null
					&& !"".equals(message.getDescription().get(i))) {
				sb.append("<Description><![CDATA[" + message.getDescription().get(i) + "]]></Description>");
			}
			if (message.getPicUrl().size() == len && message.getPicUrl().get(i) != null
					&& !"".equals(message.getPicUrl().get(i))) {
				sb.append("<PicUrl><![CDATA[" + message.getPicUrl().get(i) + "]]></PicUrl>");
			}
			if (message.getUrl().size() == len && message.getUrl().get(i) != null
					&& !"".equals(message.getUrl().get(i))) {
				sb.append("<Url><![CDATA[" + message.getUrl().get(i) + "]]></Url>");
			}
			sb.append("</item>");
		}

		sb.append("</Articles>");
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[music]]></MsgType>
	 * <Music> <Title><![CDATA[TITLE]]></Title>
	 * <Description><![CDATA[DESCRIPTION]]></Description>
	 * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
	 * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
	 * <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId> </Music> </xml>
	 * 
	 * @Title sendMusicMessage
	 * @Description 回复音乐消息
	 * @param message
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午8:31:40
	 */
	public static String sendMusicMessage(ReplayMusicMessage message) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
		sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
		sb.append("<MsgType><![CDATA[" + MessageType.MUSIC_MESSAGE + "]]></MsgType>");
		sb.append("<Music>");
		if (message.getTitle() != null && !"".equals(message.getTitle())) {
			sb.append("<Title><![CDATA[" + message.getTitle() + "]]></Title>");
		}
		if (message.getDescription() != null && !"".equals(message.getDescription())) {
			sb.append("<Description><![CDATA[" + message.getDescription() + "]]></Description>");
		}
		if (message.getMusicURL() != null && !"".equals(message.getMusicURL())) {
			sb.append("<MusicUrl><![CDATA[" + message.getMusicURL() + "]]></MusicUrl>");
		}
		if (message.getHqMusicUrl() != null && !"".equals(message.getHqMusicUrl())) {
			sb.append("<HQMusicUrl><![CDATA[" + message.getHqMusicUrl() + "]]></HQMusicUrl>");
		}

		sb.append("<ThumbMediaId><![CDATA[" + message.getThumbMediaId() + "]]></ThumbMediaId>");
		sb.append("</Music>");
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[video]]></MsgType>
	 * <Video> <MediaId><![CDATA[media_id]]></MediaId>
	 * <Title><![CDATA[title]]></Title>
	 * <Description><![CDATA[description]]></Description> </Video> </xml>
	 * 
	 * @Title sendVideoMessage
	 * @Description 回复视频消息
	 * @param message
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午8:27:26
	 */
	public static String sendVideoMessage(ReplayVideoMessage message) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
		sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
		sb.append("<MsgType><![CDATA[" + MessageType.VIDEO_MESSAGE + "]]></MsgType>");
		sb.append("<Video>");
		sb.append("<MediaId><![CDATA[" + message.getMediaId() + "]]></MediaId>");
		if (message.getTitle() != null && !"".equals(message.getTitle())) {
			sb.append("<Title><![CDATA[" + message.getTitle() + "]]></Title>");
		}
		if (message.getDescription() != null && !"".equals(message.getDescription())) {
			sb.append("<Description><![CDATA[" + message.getDescription() + "]]></Description>");
		}
		sb.append("</Video>");
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[voice]]></MsgType>
	 * <Voice> <MediaId><![CDATA[media_id]]></MediaId> </Voice> </xml>
	 * 
	 * @Title sendVoiceMessage
	 * @Description 回复语音消息
	 * @param message
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午8:24:42
	 */
	public static String sendVoiceMessage(ReplayVoiceMessage message) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
		sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
		sb.append("<MsgType><![CDATA[" + MessageType.VOICE_MESSAGE + "]]></MsgType>");
		sb.append("<Voice>");
		sb.append("<MediaId><![CDATA[" + message.getMediaId() + "]]></MediaId>");
		sb.append("</Voice>");
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[image]]></MsgType>
	 * <Image> <MediaId><![CDATA[media_id]]></MediaId> </Image> </xml>
	 * 
	 * @Title sendImageMessage
	 * @Description 回复图片消息
	 * @param message
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午8:17:08
	 */
	public static String sendImageMessage(ReplayImageMessage message) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
		sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
		sb.append("<MsgType><![CDATA[" + MessageType.IMAGE_MESSAGE + "]]></MsgType>");
		sb.append("<Image>");
		sb.append("<MediaId><![CDATA[" + message.getMediaId() + "]]></MediaId>");
		sb.append("</Image>");
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
	 * <FromUserName><![CDATA[fromUser]]></FromUserName>
	 * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[text]]></MsgType>
	 * <Content><![CDATA[你好]]></Content> </xml>
	 * 
	 * @Title sendTextMessage
	 * @Description 回复文本消息
	 * @param message
	 * @return
	 * @author Cynara-remix
	 * @Date 2016年10月12日 下午8:07:48
	 */
	public static String sendTextMessage(ReplayTextMessage message) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
		sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
		sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
		sb.append("<MsgType><![CDATA[" + MessageType.TEXT_MESSAGE + "]]></MsgType>");
		sb.append("<Content><![CDATA[" + message.getContext() + "]]></Content>");
		sb.append("</xml>");
		return sb.toString();
	}

	public static void main(String[] args) {
		ReplayTextMessage me = new ReplayTextMessage();
		me.setContext("你是猪吗");
		me.setCreateTime(new Date().getTime() + "");
		me.setFromUserName("1231231231");
		me.setToUserName("sdfasdfsdafdsf");
		System.out.println(sendTextMessage(me));
	}
}
