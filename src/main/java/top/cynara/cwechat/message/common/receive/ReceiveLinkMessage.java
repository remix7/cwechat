package top.cynara.cwechat.message.common.receive;

import java.io.Serializable;

/**
 * @ClassName LinkMessage
 * @Description 链接消息Bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:38:54
 * @version V1.0
 */
public class ReceiveLinkMessage implements Serializable {

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
	 * 消息标题
	 */
	private String title;
	/*
	 * 消息描述
	 */
	private String description;
	/*
	 * 消息URL
	 */
	private String url;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
