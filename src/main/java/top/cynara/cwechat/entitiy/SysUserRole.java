package top.cynara.cwechat.entitiy;

import java.io.Serializable;

/**
 * 
 * @ClassName SysUserRole
 * @Description 系统用户与角色之间的关系
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月8日 下午4:49:37
 * @version V1.0
 */
public class SysUserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	//关系id
	private String id;
	//用户id
	private String userId;
	//角色id
	private String roleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
