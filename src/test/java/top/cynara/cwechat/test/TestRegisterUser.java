package top.cynara.cwechat.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.cynara.cwechat.entitiy.CwechatAccess;
import top.cynara.cwechat.entitiy.RegisterUser;
import top.cynara.cwechat.utils.HashUtil;

public class TestRegisterUser {
	private ApplicationContext context;
	private SqlSessionFactory sf;
	private SqlSession session;
	@Before
	public void init() throws Exception {
		context = new ClassPathXmlApplicationContext("beans.xml");
		sf = (SqlSessionFactory) context.getBean("sessionFactory");
		session = sf.openSession();
	}
	@Test
	public void findAllCwechat() throws Exception {
		List<CwechatAccess> cList = session.selectList("top.cynara.cwechat.entitiy.mapper.CwechatAccessMapper.findAllByUserId","9cca2f3d-c80a-4f60-8dd5-ced0cf9eb600");
		System.out.println(cList.size());
	}
	@Test
	public void findAll() throws Exception {
		List<RegisterUser> selectList = session.selectList("top.cynara.cwechat.entitiy.mapper.RegisterUserMapper.findAll");
		System.out.println(selectList.size());
	}
	@Test
	public void findByUsercodeAndPassword() throws Exception {
		String statement = "top.cynara.cwechat.entitiy.mapper.RegisterUserMapper.findByUserCodeAndPassword";
		RegisterUser user =  session.selectOne(statement, Arrays.asList("cynara","cynara"));
		System.out.println(user.getId());
		
	}
	@Test
	public void update() throws Exception {
		String statement = "top.cynara.cwechat.entitiy.mapper.RegisterUserMapper.findByUserCode";
		String parameter = "cynara";
		RegisterUser user =  session.selectOne(statement, parameter);
		user.setPassword("cynara");
		statement = "top.cynara.cwechat.entitiy.mapper.RegisterUserMapper.update";
		session.update(statement, user);
	}
	@Test
	public void findByUserCode() throws Exception {
		String statement = "top.cynara.cwechat.entitiy.mapper.RegisterUserMapper.findByUserCode";
		String parameter = "cynara";
		RegisterUser user =  session.selectOne(statement, parameter);
		System.out.println(user.getUsername());
	}
	@Test
	public void delete() throws Exception {
		String statement = "top.cynara.cwechat.entitiy.mapper.RegisterUserMapper.delete";
		String parameter = "e3ce466c-11d1-4fa0-9ab3-36f6e20bffdc";
		session.delete(statement, parameter);
	}
	@Test
	public void insert() throws Exception {
		String statement = "top.cynara.cwechat.entitiy.mapper.RegisterUserMapper.insert";
		RegisterUser parameter = new RegisterUser();
		parameter.setId(UUID.randomUUID().toString());
		parameter.setLocked(1+"");
		parameter.setPassword(HashUtil.getMd5Hash("cynara", "cynara"));
		parameter.setSalt("cynara");
		parameter.setRegisterTime(new Date());
		parameter.setUsercode("cynara");
		parameter.setUsername("cynara");
		session.insert(statement, parameter);
	}
	
	@After
	public void after(){
		session.commit();
		session.close();
	}
}
