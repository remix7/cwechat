package top.cynara.cwechat.message.common.receive;

import java.io.Serializable;

/**
 * @ClassName ImageMessage
 * @Description 图片消息bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:24:15
 * @version V1.0
 */
public class ReceiveImageMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 * 开发者账号
	 */
	private String toUserName;
	/*
	 * 发送方id
	 */
	private String fromUserName;
	/*
	 * 消息创建时间
	 */
	private String createTime;
	/*
	 * 图片地址
	 */
	private String picUrl;
	/*
	 * 图片消息媒体id
	 */
	private String mediaId;
	/*
	 * 消息id
	 */
	private String msgId;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
