package top.cynara.cwechat.message.common.replay;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReplayImageTextMessage
 * @Description 回复图文消息
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月12日 下午8:02:58
 * @version V1.0
 */
public class ReplayImageTextMessage implements Serializable {
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
	 * 图文消息个数，限制为10条以内
	 */
	private String articleCount;
	/*
	 * 图文消息标题
	 */
	private List<String> Title;
	/*
	 * 图文消息描述
	 */
	private List<String> description = new ArrayList<String>();
	/*
	 * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	private List<String> picUrl = new ArrayList<String>();
	/*
	 * 点击图文消息跳转链接
	 */
	private List<String> url = new ArrayList<String>();

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

	public String getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(String articleCount) {
		this.articleCount = articleCount;
	}

	public List<String> getTitle() {
		return Title;
	}

	public void setTitle(List<String> title) {
		Title = title;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public List<String> getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(List<String> picUrl) {
		this.picUrl = picUrl;
	}

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

}
