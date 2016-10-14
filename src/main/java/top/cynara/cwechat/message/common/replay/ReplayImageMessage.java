package top.cynara.cwechat.message.common.replay;

import java.io.Serializable;

/**
 * @ClassName ImageMessage
 * @Description 图片消息bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午7:24:15
 * @version V1.0
 */
public class ReplayImageMessage implements Serializable {
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
	 * 通过素材管理中的接口上传多媒体文件，得到的id。
	 */
	private String mediaId;

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

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
