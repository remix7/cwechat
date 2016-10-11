package top.cynara.cwechat.entitiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CwechatAccess
 * @Description 微信接入记录
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月10日 下午11:11:04
 * @version V1.0
 */
public class CwechatAccessLog implements Serializable {

	private static final long serialVersionUID = 1L;
	// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	private String id;
	// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	private String signature;
	// 时间戳
	private String timestamp;
	// 随机数
	private String nonce;
	// 随机字符串
	private String echostr;
	// 链接时间
	private Date accessDate;
	// 是否连接成功
	private String isTrue;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
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
