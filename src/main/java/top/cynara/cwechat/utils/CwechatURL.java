package top.cynara.cwechat.utils;

public class CwechatURL {
	
	public static final String access_token="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//使用时要加上Access_token
	public static final String wechatServiceIP = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";
	
}
