package top.cynara.cwechat.test;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataBaseTest {
	private ApplicationContext context;
	private static Logger logger = Logger.getLogger(DataBaseTest.class);
	@Before
	public void init() throws Exception {
		context = new ClassPathXmlApplicationContext("beans.xml");
		logger.debug(context);
	}
	
	@Test
	public void getDataSource() throws Exception {
		DataSource ds = (DataSource) context.getBean("dataSource");
		logger.debug(ds);
		System.out.println(ds.getConnection());
	}
	@Test
	public void getSessionFactory() throws Exception {
		logger.error("what fuck");
	}
}
