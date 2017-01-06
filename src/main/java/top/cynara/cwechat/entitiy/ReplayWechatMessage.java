package top.cynara.cwechat.entitiy;

import java.io.Serializable;

/**
 * @ClassName ReceiveWechatMessage
 * @Description 处理回复用户的消息
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月13日 下午2:20:02
 * @version V1.0
 */
public class ReplayWechatMessage implements Serializable {

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
	 * 接受方账号id
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
	 * 图片消息媒体id 图片消息 视频消息
	 */
	private String mediaId;
	/*
	 * 消息标题 链接消息
	 */
	private String title;
	/*
	 * 消息描述 链接消息
	 */
	private String description;
	/*
	 * 音乐链接
	 */
	private String musicURL;
	/*
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String hqMusicUrl;
	/*
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。 视频消息
	 */
	private String thumbMediaId;
	/*
	 * 图片地址 图片消息
	 */
	private String picUrl;
	/*
	 * 消息URL 链接消息
	 */
	private String url;
	/*
	 * 图文消息个数，限制为10条以内
	 */
	private String articleCount;
	/*
	 * 操作用户的id
	 */
	private String receiveId;

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

	public String getMusicURL() {
		return musicURL;
	}

	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(String articleCount) {
		this.articleCount = articleCount;
	}

	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

}
