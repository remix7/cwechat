package top.cynara.cwechat.entitiy;

import java.io.Serializable;

/**
 * @ClassName ReceiveWechatMessage
 * @Description 用户发来的消息总汇
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月13日 下午2:20:02
 * @version V1.0
 */
public class ReceiveWechatMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	/*
	 * 消息类型 不同类型的值不同 全部都包含在此bean中 看需添加
	 */
	private String msgType;
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
	 * 消息内容 文本消息
	 */
	private String context;
	/*
	 * 图片地址 图片消息
	 */
	private String picUrl;
	/*
	 * 图片消息媒体id 图片消息 视频消息
	 */
	private String mediaId;
	/*
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。 视频消息
	 */
	private String thumbMediaId;
	/*
	 * 语音格式 语音消息
	 */
	private String format;
	/*
	 * 语音识别结果 语音消息
	 */
	private String recognition;
	/*
	 * 地理位置维度 地理位置消息
	 */
	private String location_X;
	/*
	 * 地理位置经度 地理位置消息
	 */
	private String location_Y;
	/*
	 * 地图缩放大小 地理位置消息
	 */
	private String scale;
	/*
	 * 地理位置信息 地理位置消息
	 */
	private String label;
	/*
	 * 消息标题 链接消息
	 */
	private String title;
	/*
	 * 消息描述 链接消息
	 */
	private String description;
	/*
	 * 消息URL 链接消息
	 */
	private String url;
	/*
	 * 消息id
	 */
	private String msgId;
	/*
	 * 操作用户的id
	 */
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
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

	@Override
	public String toString() {
		return "ReceiveWechatMessage [id=" + id + ", msgType=" + msgType + ", toUserName=" + toUserName
				+ ", fromUserName=" + fromUserName + ", createTime=" + createTime + ", context=" + context + ", picUrl="
				+ picUrl + ", mediaId=" + mediaId + ", thumbMediaId=" + thumbMediaId + ", format=" + format
				+ ", recognition=" + recognition + ", location_X=" + location_X + ", location_Y=" + location_Y
				+ ", scale=" + scale + ", label=" + label + ", title=" + title + ", description=" + description
				+ ", url=" + url + ", msgId=" + msgId + ", userId=" + userId + "]";
	}
}
