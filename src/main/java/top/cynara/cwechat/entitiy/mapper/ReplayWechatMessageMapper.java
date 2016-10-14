package top.cynara.cwechat.entitiy.mapper;

import java.util.List;

import top.cynara.cwechat.entitiy.ReplayWechatMessage;
/**
 * @ClassName ReplayWechatMessageMapper 
 * @Description TODO 
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月14日 下午12:06:22 
 * @version V1.0
 */
public interface ReplayWechatMessageMapper {
	void insert(ReplayWechatMessage message);
	void delete(String id);
	void update(ReplayWechatMessage message);
	ReplayWechatMessage findById(String id);
	List<ReplayWechatMessage> findAll();
	List<ReplayWechatMessage> findByUserId(String userId);
}
