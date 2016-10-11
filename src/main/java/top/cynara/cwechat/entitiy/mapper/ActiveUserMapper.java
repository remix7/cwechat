package top.cynara.cwechat.entitiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.cynara.cwechat.entitiy.SysPermission;
/**
 * @ClassName ActiveUserMapper 
 * @Description 当前活动用户的按钮和权限方法
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月9日 下午3:05:32 
 * @version V1.0
 */
public interface ActiveUserMapper {
	/**
	 * @Title findAllMenuBySysUserId 
	 * @Description 当前活动用户的按钮
	 * @param id
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月9日 下午3:05:54
	 */
	List<SysPermission> findAllMenuBySysUserId(@Param("id") String id);
	/**
	 * @Title findAllPermissionByUserId 
	 * @Description 当前活动用户的权限
	 * @param id
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月9日 下午3:06:08
	 */
	List<SysPermission> findAllPermissionByUserId(@Param("id")String id);
}
