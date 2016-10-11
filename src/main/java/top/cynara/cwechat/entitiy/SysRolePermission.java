package top.cynara.cwechat.entitiy;

import java.io.Serializable;

/**
 * @ClassName SysRolePermission
 * @Description 角色和权限的关系
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月8日 下午4:48:31
 * @version V1.0
 */
public class SysRolePermission implements Serializable {
	private static final long serialVersionUID = 1L;
	// 关系id
	private String id;
	// 角色id
	private String roleId;
	// 权限id
	private String permissionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

}
