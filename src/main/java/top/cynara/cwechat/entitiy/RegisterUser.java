package top.cynara.cwechat.entitiy;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName RegisterUser 
 * @Description 注册用户
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月8日 下午7:56:04 
 * @version V1.0
 */
public class RegisterUser implements Serializable {
	private static final long serialVersionUID = 1L;
	// 注册用户的id
	private String id;
	// 注册用户的昵称
	@NotEmpty
	private String username;
	// 注册用户的登录名
	@NotEmpty
	private String usercode;
	// 注册用户的密码
	@NotEmpty
	@Length(min=6,max=16)
	private String password;
	//手机号
	@NotEmpty
	private String phone;
	//邮箱
	@NotEmpty
	@Email
	private String email;
	// 注册时间
	private Date registerTime;
	// 密码加密时用的盐
	private String salt;
	// 是否锁定
	private String locked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
