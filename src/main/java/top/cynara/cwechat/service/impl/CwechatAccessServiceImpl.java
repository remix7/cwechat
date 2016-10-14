package top.cynara.cwechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.cwechat.entitiy.CwechatAccess;
import top.cynara.cwechat.entitiy.mapper.CwechatAccessMapper;
import top.cynara.cwechat.service.CwechatAccessService;
@Service("CwechatAccessService")
public class CwechatAccessServiceImpl implements CwechatAccessService{

	@Autowired
	private CwechatAccessMapper mapper;
	
	public void insert(CwechatAccess access) {
		mapper.insert(access);
	}

	public void delete(String id) {
		mapper.delete(id);
	}

	public void update(CwechatAccess access) {
		mapper.update(access);
	}

	public CwechatAccess findById(String id) {
		return mapper.findById(id);
	}

	public List<CwechatAccess> findAll() {
		return mapper.findAll();
	}

	public List<CwechatAccess> findAllByUserId(String userid) {
		return mapper.findAllByUserId(userid);
	}

	public CwechatAccess findByAppId(String appid) {
		return mapper.findByAppId(appid);
	}

}
