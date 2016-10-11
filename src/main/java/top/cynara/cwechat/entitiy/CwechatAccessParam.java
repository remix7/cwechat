package top.cynara.cwechat.entitiy;

import java.io.Serializable;
import java.util.Date;

public class CwechatAccessParam implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String url;
	private String token;
	private String encodingAesKey;
	private Date accessDate;
	private String isTrue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

	public Date getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

	public String getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}

}
