package top.cynara.cwechat.entitiy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 微信自定义按钮
 * @ClassName CwechatMenu 
 * @Description 微信按钮设置
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月12日 下午2:11:04 
 * @version V1.0
 */
import java.util.Map;

import net.sf.json.JSONObject;

public class CwechatMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String menuKey;
	private String type;// click or view
	private String url;// 如果view url不能为空
	private String msgType;// 消息类型，是文本消息还是图文消息
	private String orders;
	// 多级菜单
	//private CwechatMenu cMenu;
	//多级菜单
	//private List<CwechatMenu> cMenuList ;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public static void main(String[] args) {
		CwechatMenu m = new CwechatMenu();
		m.setMenuKey("v100");
		m.setName("歌曲");
		m.setMsgType("text");
		m.setUrl("http://cynara.top");
		m.setOrders("orders");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = new ArrayList<Object>();
		list.add(m);
		map.put("button", list);
		JSONObject js = JSONObject.fromObject(map);
		System.out.println(js);
	}
}
