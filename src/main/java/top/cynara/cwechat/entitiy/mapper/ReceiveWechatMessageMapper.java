package top.cynara.cwechat.entitiy.mapper;

import java.util.List;

import top.cynara.cwechat.entitiy.ReceiveWechatMessage;
/**
 * @ClassName ReceiveWechatMessageMapper 
 * @Description 用户消息保存接口
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月13日 下午2:22:39 
 * @version V1.0
 */
public interface ReceiveWechatMessageMapper {
	void insert(ReceiveWechatMessage message);
	void delete(String id);
	void update(ReceiveWechatMessage message);
	ReceiveWechatMessage findById(String id);
	List<ReceiveWechatMessage> findAllByUserId(String userId);
	List<ReceiveWechatMessage> findAll();
}
