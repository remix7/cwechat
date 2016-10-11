package top.cynara.cwechat.entitiy;

import java.io.Serializable;
/**
 * 
 * @ClassName SysPermission 
 * @Description 系统的权限信息
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月8日 下午4:47:31 
 * @version V1.0
 */
public class SysPermission implements Serializable {

	private static final long serialVersionUID = 1L;
	// 权限id
	private String id;
	// 权限名称
	private String name;
	// 权限类型
	private String type;
	// 权限url
	private String url;
	// 权限识别码
	private String percode;
	// 状态码
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

}
