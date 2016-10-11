package top.cynara.cwechat.entitiy.mapper;

import java.util.List;

import top.cynara.cwechat.entitiy.RegisterUser;
/**
 * @ClassName RegisterUserMapper 
 * @Description 注册用户增删改查方法
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月9日 下午3:05:01 
 * @version V1.0
 */
public interface RegisterUserMapper {
	/**
	 * @Title insert 
	 * @Description 插入用户  用户注册时使用
	 * @param user       
	 * @author Cynara-remix
	 * @Date 2016年10月8日 下午7:59:08
	 */
	void insert(RegisterUser user);
	/**
	 * @Title delete 
	 * @Description 删除用户
	 * @param id       
	 * @author Cynara-remix
	 * @Date 2016年10月8日 下午7:59:31
	 */
	void delete(String id);
	/**
	 * @Title update 
	 * @Description 用户更新
	 * @param user       
	 * @author Cynara-remix
	 * @Date 2016年10月8日 下午7:59:46
	 */
	void update(RegisterUser user);
	/**
	 * @Title findByUserCode 
	 * @Description 根据登录名查询用户
	 * @param usercode
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月8日 下午8:00:00
	 */
	RegisterUser findByUserCode(String usercode);
	/**
	 * @Title findAll 
	 * @Description 查询所用用户
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月8日 下午8:00:18
	 */
	List<RegisterUser> findAll();
	/**
	 * @Title findByUserCodeAndPassword 
	 * @Description 根据用户名密码查询用户
	 * @param usercode
	 * @param password
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月8日 下午8:00:34
	 */
	RegisterUser findByUserCodeAndPassword(String usercode,String password);
}
