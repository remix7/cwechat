package top.cynara.cwechat.entitiy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.cynara.cwechat.entitiy.CwechatAccess;
/**
 * @ClassName CwechatAccessMapper 
 * @Description 处理用户的公众号 参数
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月11日 下午8:24:10 
 * @version V1.0
 */
public interface CwechatAccessMapper {
	/**
	 * @Title insert 
	 * @Description 添加
	 * @param access       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午8:25:44
	 */
	void insert(CwechatAccess access);
	/**
	 * @Title delete 
	 * @Description 删除
	 * @param id       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午8:25:56
	 */
	void delete(String id);
	/**
	 * @Title update 
	 * @Description 修改
	 * @param access       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午8:26:04
	 */
	void update(CwechatAccess access);
	/**
	 * @Title findById 
	 * @Description 查询一个
	 * @param id
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午8:26:13
	 */
	CwechatAccess findById(String id);
	/**
	 * @Title findAll 
	 * @Description 查询全部
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午8:26:32
	 */
	List<CwechatAccess> findAll();
	/**
	 * @Title findAllByUserId 
	 * @Description 根据用户id来查询用户的接入微信信息
	 * @param userid
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午9:06:29
	 */
	List<CwechatAccess> findAllByUserId(@Param("userId")String userId);
	
	CwechatAccess findByAppId(@Param("appid")String appid);
}
