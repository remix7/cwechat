package top.cynara.cwechat.message.common.replay;

import java.io.Serializable;

/**
 * @ClassName TextMessage
 * @Description 处理微信文本消息bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:21:29
 * @version V1.0
 */
public class ReplayTextMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 *接收方账号id 
	 */
	private String toUserName;
	/*
	 *开发者微信号
	 */
	private String fromUserName;
	/*
	 *消息创建时间
	 */
	private String createTime;
	/*
	 *消息内容 
	 */
	private String context;

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

}
