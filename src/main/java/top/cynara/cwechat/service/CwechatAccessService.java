package top.cynara.cwechat.service;

import java.util.List;

import top.cynara.cwechat.entitiy.CwechatAccess;

public interface CwechatAccessService {
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
	List<CwechatAccess> findAllByUserId(String userid);
	CwechatAccess findByAppId(String appid);
}
