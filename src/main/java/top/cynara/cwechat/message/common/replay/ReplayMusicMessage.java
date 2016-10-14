package top.cynara.cwechat.message.common.replay;

import java.io.Serializable;

/**
 * @ClassName ReplayMusicMessage
 * @Description 回复音乐消息
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:58:22
 * @version V1.0
 */
public class ReplayMusicMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	 * 接受方账号id
	 */
	private String toUserName;
	/*
	 * 开发者微信号
	 */
	private String fromUserName;
	/*
	 * 消息创建时间
	 */
	private String createTime;
	/*
	 * 音乐标题
	 */
	private String title;
	/*
	 * 音乐描述
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
	 * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	 */
	private String thumbMediaId;

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

}
