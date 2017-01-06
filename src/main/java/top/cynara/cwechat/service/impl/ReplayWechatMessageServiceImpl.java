package top.cynara.cwechat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.cynara.cwechat.entitiy.ReplayWechatMessage;
import top.cynara.cwechat.entitiy.mapper.ReplayWechatMessageMapper;
import top.cynara.cwechat.service.ReplayWechatMessageService;

@Service("ReplayWechatMessage")
public class ReplayWechatMessageServiceImpl implements ReplayWechatMessageService {

	@Autowired
	private ReplayWechatMessageMapper mapper;

	public void insert(ReplayWechatMessage message) {
		mapper.insert(message);
	}

	public void delete(String id) {
		mapper.delete(id);
	}

	public void update(ReplayWechatMessage message) {
		mapper.update(message);
	}

	public ReplayWechatMessage findById(String id) {
		return mapper.findById(id);
	}

	public List<ReplayWechatMessage> findAll() {
		return mapper.findAll();
	}

	public ReplayWechatMessage findByReceiveId(String receiveId) {
		return mapper.findByReceiveId(receiveId);
	}

	
}
