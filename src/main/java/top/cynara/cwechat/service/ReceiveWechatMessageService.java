package top.cynara.cwechat.service;

import java.util.List;

import top.cynara.cwechat.entitiy.ReceiveWechatMessage;
/**
 * @ClassName ReceiveWechatMessageService 
 * @Description 用户消息保存service接口
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月13日 下午2:51:10 
 * @version V1.0
 */
public interface ReceiveWechatMessageService {
	void insert(ReceiveWechatMessage message);
	void delete(String id);
	void update(ReceiveWechatMessage message);
	ReceiveWechatMessage findById(String id);
	List<ReceiveWechatMessage> findAllByUserId(String userId);
	List<ReceiveWechatMessage> findAll();
}
