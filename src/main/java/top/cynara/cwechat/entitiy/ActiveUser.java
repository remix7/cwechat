package top.cynara.cwechat.entitiy;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ActiveUser
 * @Description 当前活动的用户
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月8日 下午4:42:19
 * @version V1.0
 */
public class ActiveUser implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户id
	private String userid;
	// 用户登录名
	private String usercode;
	// 用户昵称
	private String username;
	// 用户拥有的按钮
	private List<SysPermission> menus;
	// 用户拥有的权限
	private List<SysPermission> permissions;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SysPermission> getMenus() {
		return menus;
	}

	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

}
