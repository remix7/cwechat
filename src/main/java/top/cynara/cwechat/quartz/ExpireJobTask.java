package top.cynara.cwechat.quartz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.cynara.cwechat.entitiy.CwechatAccess;
import top.cynara.cwechat.entitiy.CwechatFollowUser;
import top.cynara.cwechat.service.CwechatAccessService;
import top.cynara.cwechat.service.CwechatFollowUserService;
import top.cynara.cwechat.utils.CwechatConnectionUtil;
/**
 * @ClassName ExpireJobTask 
 * @Description 定时执行任务
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月18日 下午8:39:51 
 * @version V1.0
 */
@Component
public class ExpireJobTask {
	@Autowired
	private CwechatFollowUserService followUserService;
	@Autowired
	private CwechatAccessService accessService;

	public void execute() {
		
		List<CwechatAccess> accessList = accessService.findAll();
		for (CwechatAccess cwechatAccess : accessList) {
			System.out.println(cwechatAccess.getId());
			List<String> oldList = followUserService.findAllFollowOpenIdByAccessId(cwechatAccess.getId());
			List<String> newList = null;
			if(oldList.size()!=0){
				newList = CwechatConnectionUtil.findAllFollwOperId(cwechatAccess.getAppid(),cwechatAccess.getSecret(),oldList.get(oldList.size()-1));
				for (String string : newList) {
					followUserService.insert(new CwechatFollowUser(string, new Date(), cwechatAccess.getId()));
				}
			}else{
				newList = CwechatConnectionUtil.findAllFollwOperId(cwechatAccess.getAppid(),cwechatAccess.getSecret(),"-1");
				for (String string : newList) {
					followUserService.insert(new CwechatFollowUser( string, new Date(), cwechatAccess.getId()));
				}
			}
		}
	}

}
