package top.cynara.cwechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CwechatController {
	@RequestMapping("/viewAccess")
	public String viewAccess(){
		return "viewaccess";
	}
}
