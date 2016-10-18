package top.cynara.cwechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.cwechat.entitiy.CwechatFollowUser;
import top.cynara.cwechat.entitiy.mapper.CwechatFollowUserMapper;
import top.cynara.cwechat.service.CwechatFollowUserService;
@Service("CwechatFollowUserService")
public class CwechatFollowUserServiceImpl implements CwechatFollowUserService {
	@Autowired
	private CwechatFollowUserMapper mapper;
	
	public void insert(CwechatFollowUser user) {
		mapper.insert(user);
	}

	public List<CwechatFollowUser> findAllByAccessId(String accessId) {
		return mapper.findAllByAccessId(accessId);
	}

	public List<String> findAllFollowOpenIdByAccessId(String accessId) {
		return mapper.findAllFollowOpenIdByAccessId(accessId);
	}

	

}
