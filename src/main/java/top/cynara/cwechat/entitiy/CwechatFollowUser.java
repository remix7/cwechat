package top.cynara.cwechat.entitiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CwechatFollowUser
 * @Description 微信的关注用户
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月16日 下午9:27:29
 * @version V1.0
 */
public class CwechatFollowUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String openId;
	private Date createDate;
	private String accessId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAccessId() {
		return accessId;
	}

	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public CwechatFollowUser( String openId, Date createDate, String accessId) {
		this.id = id;
		this.openId = openId;
		this.createDate = createDate;
		this.accessId = accessId;
	}

	public CwechatFollowUser() {
	}
	
}
