package top.cynara.cwechat.message.common.receive;

import java.io.Serializable;

/**
 * @ClassName VoiceMessage
 * @Description 语音消息bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:28:13
 * @version V1.0
 */
public class ReceiveVoiceMessage implements Serializable {

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
	 * 语音格式
	 */
	private String format;
	/*
	 *语音识别结果 
	 */
	private String recognition;
	/*
	 * 消息id
	 */
	private String msgId;

	
	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
