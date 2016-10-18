package top.cynara.cwechat.service;

import java.util.List;

import top.cynara.cwechat.entitiy.CwechatFollowUser;

/**
 * @ClassName CwechatFollowUserService 
 * @Description 关注用户处理service 接口
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月16日 下午9:47:19 
 * @version V1.0
 */
public interface CwechatFollowUserService {
	/**
	 * @Title insert 
	 * @Description 添加
	 * @param user       
	 * @author Cynara-remix
	 * @Date 2016年10月16日 下午9:36:14
	 */
	void insert(CwechatFollowUser user);
	/**
	 * @Title findAllByAccessIdl 
	 * @Description 根据微信链接id来查询
	 * @param accessId
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月16日 下午9:36:27
	 */
	List<CwechatFollowUser> findAllByAccessId(String accessId);
	/**
	 * @Title findAllFollowAccessId 
	 * @Description 获取所有的关注用户
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月17日 下午10:33:28
	 */
	List<String> findAllFollowOpenIdByAccessId(String accessId);
}
