package top.cynara.cwechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.cwechat.entitiy.ReceiveWechatMessage;
import top.cynara.cwechat.entitiy.mapper.ReceiveWechatMessageMapper;
import top.cynara.cwechat.service.ReceiveWechatMessageService;

/**
 * 
 * @ClassName ReceiveWechatMessageServiceImpl
 * @Description TODO
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月13日 下午2:51:59
 * @version V1.0
 */
@Service("ReceiveWechatMessageService")
public class ReceiveWechatMessageServiceImpl implements ReceiveWechatMessageService {
	@Autowired
	private ReceiveWechatMessageMapper mapper;

	public void insert(ReceiveWechatMessage message) {
		mapper.insert(message);
	}

	public void delete(String id) {
		mapper.delete(id);
	}

	public void update(ReceiveWechatMessage message) {
		mapper.update(message);
	}

	public ReceiveWechatMessage findById(String id) {
		return mapper.findById(id);
	}

	public List<ReceiveWechatMessage> findAll() {
		return mapper.findAll();
	}

	public List<ReceiveWechatMessage> findAllByToUserName(String toUserName) {
		return mapper.findAllByToUserName(toUserName);
	}

}
