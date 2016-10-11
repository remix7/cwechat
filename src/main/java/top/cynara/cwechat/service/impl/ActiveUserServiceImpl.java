package top.cynara.cwechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.cwechat.entitiy.SysPermission;
import top.cynara.cwechat.entitiy.mapper.ActiveUserMapper;
import top.cynara.cwechat.service.ActiveUserService;
@Service("ActiveUserService")
public class ActiveUserServiceImpl implements ActiveUserService {
	
	@Autowired
	private ActiveUserMapper mapper;
	public List<SysPermission> findAllMenuBySysUserId(String id) {
		
		return mapper.findAllMenuBySysUserId(id);
	}

	public List<SysPermission> findAllPermissionByUserId(String id) {
		return mapper.findAllPermissionByUserId(id);
	}

}
