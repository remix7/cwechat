package top.cynara.cwechat.message.common.receive;

import java.io.Serializable;

/**
 * @ClassName PosotionMessage
 * @Description 地理位置消息Bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:35:53
 * @version V1.0
 */
public class ReceivePosotionMessage implements Serializable {

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
	 * 地理位置维度
	 */
	private String location_X;
	/*
	 * 地理位置经度
	 */
	private String location_Y;
	/*
	 * 地图缩放大小
	 */
	private String scale;
	/*
	 * 地理位置信息
	 */
	private String label;
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

	public String getLocation_X() {
		return location_X;
	}

	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}

	public String getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
