package top.cynara.cwechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.cwechat.entitiy.RegisterUser;
import top.cynara.cwechat.entitiy.mapper.RegisterUserMapper;
import top.cynara.cwechat.service.RegisterUserService;
@Service("RegisterUserService")
public class RegisterUserServiceImpl implements RegisterUserService {
	
	@Autowired
	private RegisterUserMapper mapper;
	
	public void insert(RegisterUser user) {
		mapper.insert(user);
	}

	public void delete(String id) {
		mapper.delete(id);
	}

	public void update(RegisterUser user) {
		mapper.update(user);
	}

	public RegisterUser findByUserCode(String usercode) {
		return mapper.findByUserCode(usercode);
	}

	public List<RegisterUser> findAll() {
		return mapper.findAll();
	}

	public RegisterUser findByUserCodeAndPassword(String usercode, String password) {
		return mapper.findByUserCodeAndPassword(usercode, password);
	}
}
