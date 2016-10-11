package top.cynara.cwechat.entitiy;

import java.io.Serializable;
/**
 * 
 * @ClassName SysRole 
 * @Description 系统的角色信息 
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月8日 下午4:47:14 
 * @version V1.0
 */
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;
	// 角色id
	private String id;
	// 角色名称
	private String name;
	// 角色状态
	private String available;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}
}
