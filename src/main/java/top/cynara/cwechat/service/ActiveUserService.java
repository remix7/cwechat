package top.cynara.cwechat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.cynara.cwechat.entitiy.SysPermission;


public interface ActiveUserService {
	List<SysPermission> findAllMenuBySysUserId(@Param("id") String id);
	List<SysPermission> findAllPermissionByUserId(@Param("id")String id);
}
