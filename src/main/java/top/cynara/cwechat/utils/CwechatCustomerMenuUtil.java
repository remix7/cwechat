package top.cynara.cwechat.utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @ClassName CwechatCustomerMenuUtil 
 * @Description 将对象转换为json 
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月11日 下午1:10:28 
 * @version V1.0
 */
public class CwechatCustomerMenuUtil {
	public static String getJSON(Map<Object, Object> map){
		return JSONObject.fromObject(map).toString();
	}
	public static void main(String[] args) {
		Map<Object,Object> map = new HashMap<Object, Object>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("name", "金曲");
		m1.put("type", "click");
		m1.put("key", "v10000");
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("name", "菜单");
		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("type", "view");
		m3.put("name", "搜索");
		m3.put("url", "http://www.cynara.top");
		Map<String, Object> m4 = new HashMap<String, Object>();
		m4.put("type", "view");
		m4.put("name", "视频");
		m4.put("url", "http://v.baidu.con");
		m2.put("sub_button", new Object[]{m3,m4});
		map.put("button", new Object[]{m1,m2});
		System.out.println(getJSON(map));
	}
}
