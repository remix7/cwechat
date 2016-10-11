package top.cynara.cwechat.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;

/**
 * @ClassName HashUtil 
 * @Description 散列支持
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月8日 下午1:43:23 
 * @version V1.0
 */
public class HashUtil {
	
	/** 
	 * @Title getMd5Hash 
	 * @Description md5hash散列两次 
	 * @param password
	 * @param salt
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年9月29日 下午8:05:42 
	 */
	public static String getMd5Hash(String password,String salt){
		//盐是将传递过来的盐进行翻转后使用
		return new Md5Hash(password, new StringBuffer(salt).reverse().toString(), 2).toString();
	}
	/**
	 * @Title getShaHash 
	 * @Description Sha1Hash 散列2次
	 * @param password
	 * @param salt
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年9月29日 下午8:06:23
	 */
	public static String getShaHash(String password,String salt){
		return new Sha1Hash(password, salt, 2).toString();
	}
	public static void main(String[] args) {
		System.out.println(getMd5Hash("cynara", "cynara"));
	}
	
}
