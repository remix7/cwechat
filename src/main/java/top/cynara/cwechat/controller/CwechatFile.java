package top.cynara.cwechat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import top.cynara.cwechat.entitiy.ActiveUser;
import top.cynara.cwechat.entitiy.CwechatAccess;
import top.cynara.cwechat.service.CwechatAccessService;
import top.cynara.cwechat.utils.CwechatConnectionUtil;
import top.cynara.cwechat.utils.CwechatFileUtil;

/**
 * @ClassName CwechatFile
 * @Description 微信资源文件下载于上传
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月15日 下午3:11:17
 * @version V1.0
 */
@Controller
public class CwechatFile {

	@Autowired
	private CwechatAccessService cwechatAccessService;

	@RequestMapping("/fileUpload")
	public void fileUpload(@RequestParam("media") MultipartFile file) {
		 System.out.println(CwechatFileUtil.wechatFileUpload("https://api.weixin.qq.com/cgi-bin/media/upload?access_token="+CwechatConnectionUtil.getAccesssToken("wx2c480b56a658c0ab",
		 "dc51c5de30eaf742716f752625e0bc75")+"&type=image",file));
	}

	@RequestMapping("/download/{mediaId}")
	public void download(@PathVariable("mediaId") String mediaId, HttpSession session, HttpServletResponse response,
			HttpServletRequest request)
			throws IOException {
		// 获取当前用户
		ActiveUser user = (ActiveUser) session.getAttribute("activeUser");
		// 获取用户对应点公众号 此处仅为第一个
		List<CwechatAccess> accessList = cwechatAccessService.findAllByUserId(user.getUserid());
		// 活动access_token
		String access_token = CwechatConnectionUtil.getAccesssToken(accessList.get(0).getAppid(),
				accessList.get(0).getSecret());

		CwechatFileUtil.wechatFileDownload(response,request, access_token, mediaId);
	}

}
