package top.cynara.cwechat.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.cynara.cwechat.entitiy.ReceiveWechatMessage;

public class ReceiveWechatMessageTest {
	private ApplicationContext context;
	private SqlSessionFactory sf;
	private SqlSession session;
	@Before
	public void init() throws Exception {
		context = new ClassPathXmlApplicationContext("beans.xml");
		sf = (SqlSessionFactory) context.getBean("sessionFactory");
		session = sf.openSession();
	}
	@After
	public void after(){
		session.commit();
		session.close();
	}
	@Test
	public void testInsert() throws Exception {
		String statement = "top.cynara.cwechat.entitiy.mapper.ReceiveWechatMessageMapper.insert";
		ReceiveWechatMessage message = new ReceiveWechatMessage();
		message.setContext("context");
		message.setCreateTime(new Date().getTime()+"");
		message.setDescription("description");
		message.setFormat("formt");
		message.setFromUserName("fromUserName");
		message.setId(UUID.randomUUID().toString());
		message.setLabel("label");
		message.setLocation_X("location_X");
		message.setLocation_Y("location_Y");
		message.setMediaId("mediaId");
		message.setMsgId("msgid");
		message.setMsgType("msgtype");
		message.setPicUrl("picUrl");
		message.setRecognition("recognition");
		message.setScale("scale");
		message.setThumbMediaId("thubmMediaId");
		message.setTitle("title");
		message.setToUserName("toUserName");
		message.setUrl("url");
		message.setUserId("userId");
		session.insert(statement, message);
	}
	public static void main(String[] args) {
		System.out.println(new Date().getTime()+"");
	}
}
