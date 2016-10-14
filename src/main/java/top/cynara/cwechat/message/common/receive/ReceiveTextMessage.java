package top.cynara.cwechat.message.common.receive;

import java.io.Serializable;

/**
 * @ClassName TextMessage
 * @Description 处理微信文本消息bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:21:29
 * @version V1.0
 */
public class ReceiveTextMessage implements Serializable {
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
	 * 消息内容
	 */
	private String context;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "ReceiveTextMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime="
				+ createTime + ", context=" + context + ", msgId=" + msgId + "]";
	}

}
