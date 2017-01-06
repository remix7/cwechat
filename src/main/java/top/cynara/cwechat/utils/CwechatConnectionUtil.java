package top.cynara.cwechat.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 * @ClassName CwechatConnectionUtil 
 * @Description 链接微信帮助工具
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月11日 下午12:36:47 
 * @version V1.0
 */
public class CwechatConnectionUtil {
	private static Logger log = Logger.getLogger(CwechatConnectionUtil.class);
	/**
	 * @Title findUserByOpenId 
	 * @Description 根据微信id获取用户信息  不存数据库的原因是因为 这个更加真实
	 * @param appid
	 * @param secret
	 * @param openId
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月18日 下午9:09:46
	 */
	public static Map<String, String> findUserByOpenId(String appid,String secret,String openId){
		Map<String, String> resMap = new HashMap<String, String>();
		String access_token = getAccesssToken(appid, secret);
		try {
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openId+"&lang=zh_CN");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JSONObject jb = new JSONObject(br.readLine());
			Iterator<String> it  = jb.keys();
			while(it.hasNext()){
				String key = String.valueOf(it.next());
				String value = jb.get(key)+"";
				resMap.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
		
	}
	/**
	 * @Title findAllFollwOperId 
	 * @Description 获取微信关注openId
	 * @param appid
	 * @param secret
	 * @param nextId
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月18日 下午7:19:36
	 */
	public static List<String> findAllFollwOperId(String appid,String secret,String nextId){
		List<String> list = new ArrayList<String>();
		String access_token = getAccesssToken(appid, secret);
		if(access_token==null){
			return null;
		}
		try {
			URL  url = null;
			if("-1".equals(nextId)){
				url = new URL("https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token);
			}else{
				url = new URL("https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token+"&next_openid="+nextId);
			}
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = in.readLine();
			in.close();
			JSONObject jb = new JSONObject(line);
			JSONObject jb2 = new JSONObject(jb.get("data").toString());
			JSONArray jsonArray = jb2.getJSONArray("openid");
			for(int i=0;i<jsonArray.length();i++){
				list.add(jsonArray.getString(i));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	/**
	 * @Title setWechatMenu 
	 * @Description 设置公众号的菜单  这里map转json  构建map是难点
	 * @param map 
	 * @param appid
	 * @param secret
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午2:01:51
	 */
	public static String setWechatMenu(Map<Object, Object> map,String appid,String secret){
		String isSuccess = "";
		try {
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+getAccesssToken(appid, secret));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.connect();
			OutputStream out = connection.getOutputStream();
			out.write(CwechatCustomerMenuUtil.getJSON(map).getBytes());
			out.flush();
			out.close();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = in.readLine();
			JSONObject jo = new JSONObject(line);
			isSuccess = jo.get("errcode").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	/**
	 * 
	 * @Title getWechatServerIP 
	 * @Description 根据appid 和secret 获取ips
	 * @param appid
	 * @param secret
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午12:36:06
	 */
	public static List<String> getWechatServerIP(String appid,String secret){
		List<String> ipList = new ArrayList<String>();
		try {
			//构建url
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token="+getAccesssToken(appid, secret));
			//打开链接
			URLConnection connection = url.openConnection();
			//打开实际链接
			connection.connect();
			//构建输出流
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = in.readLine();
			JSONObject jo = new JSONObject(line);
			//格式化字符串
			String ips = jo.get("ip_list").toString().substring(1, jo.get("ip_list").toString().length()-1);
			String ipst[] = ips.split(",");
			for (int i = 0; i < ipst.length; i++) {
				ipList.add(ipst[i].substring(1,ipst[i].length()-1) );
			}
			log.debug("ipList get success"+ipList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ipList;
	}
	/**
	 * @Title getAccesssToken 
	 * @Description 根据appid 和secret 获取access_token
	 * @param appid
	 * @param secret
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月11日 下午12:22:35
	 */
	public static String getAccesssToken(String appid,String secret){
		String access_token = "";
		try {
			//获取accessToken地址的url
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret);
			//打开链接
			URLConnection connection = url.openConnection();
			//建立时间链接
			connection.connect();
			//构建输出流
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			//转换为json
			String line = in.readLine();
			JSONObject jo = new JSONObject(line);
			access_token = jo.getString("access_token");
			log.debug("access_token get success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return access_token;
	}
<<<<<<< HEAD
	public static void main(String[] args) {
		
	}
=======
	
>>>>>>> 8454e8acb16d7a57ce4c3091d47a42e8dc2b7d38
}
