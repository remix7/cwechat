package top.cynara.cwechat.entitiy;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName CwechatAccess
 * @Description 微信接入记录
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月10日 下午11:11:04
 * @version V1.0
 */
public class CwechatAccess implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	// 第三方用户唯一凭证
	@NotEmpty
	private String appid;
	// 应用密钥
	@NotEmpty
	private String secret;
	// 消息密钥
	@NotEmpty
	private String encodingAESKey;
	// 链接时间
	private Date accessDate;
	// 是否连接成功
	private String isTrue;
	// 操作用户id
	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Date getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public String getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
