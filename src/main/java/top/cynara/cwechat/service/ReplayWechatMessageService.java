package top.cynara.cwechat.service;

import java.util.List;

import top.cynara.cwechat.entitiy.ReplayWechatMessage;

/**
 * @ClassName ReplayWechatMessageService 
 * @Description 回复用户消息保存 
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月14日 下午12:34:01 
 * @version V1.0
 */
public interface ReplayWechatMessageService {
	void insert(ReplayWechatMessage message);
	void delete(String id);
	void update(ReplayWechatMessage message);
	ReplayWechatMessage findById(String id);
	List<ReplayWechatMessage> findAll();
	ReplayWechatMessage findByReceiveId(String receiveId);
}
