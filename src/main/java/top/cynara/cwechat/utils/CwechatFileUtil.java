package top.cynara.cwechat.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName CwechatFileUtil 
 * @Description 提供微信资源的上传与下载
 * @author Cynara-remix http://cynara.top
 * E-mail remix7@live.cn 
 * @date 2016年10月15日 下午9:52:30 
 * @version V1.0
 */
public class CwechatFileUtil {
	private static Logger log = Logger.getLogger(CwechatFileUtil.class);
	/**
	 * @Title wechatFileUpload 
	 * @Description 用于文件上传
	 * @param path 要请求的地址
	 * @param file
	 * @return       
	 * @author Cynara-remix
	 * @Date 2016年10月15日 下午10:12:15
	 */
	public static String wechatFileUpload(String path,MultipartFile file)  {
		if(path == null){
			return null;
		}
		String response = "";
        BufferedReader bufferedReader = null;
        HttpsURLConnection conn = null;
        try {
			URL url = new URL(path);
			conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			//设置请求头信息
			conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");  
            conn.setRequestProperty("Charset", "UTF-8");  
            String boundary = "----------"+System.currentTimeMillis();
            conn.setRequestProperty("Content-Type","multipart/form-data;boundary="+boundary);
            //请求正文部分
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(boundary);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\""+file.getName()+"\";filename=\""+file.getOriginalFilename()+"\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            //获取输出流
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            //将头写入
            out.write(sb.toString().getBytes("UTF-8"));
            log.info(sb);
            //正文部分
            DataInputStream in  = new DataInputStream(file.getInputStream());
            byte[] b = new byte[1024];
            int len = 0;
            while((len=in.read(b))!=-1){
            	out.write(b, 0, len);
            }
            in.close();
            //将末尾写入
            out.write(("\r\n--"+boundary+"--\r\n").getBytes("UTF-8"));
            out.flush();
			out.close();
			conn.connect();
			bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String str = null;
			while((str = bufferedReader.readLine())!=null){
				response+=str;
			}
		} catch (Exception e) {
			
		}
		return response;
	}
	/**
	 * @Title wechatFileDownload 
	 * @Description 用于微信文件下载
	 * @param response 相应给浏览器
	 * @param access_token 凭证
	 * @param mediaId  要下载的资源id
	 * @author Cynara-remix
	 * @Date 2016年10月15日 下午10:06:47
	 */
	public static void wechatFileDownload(HttpServletResponse response, String access_token,String mediaId) {
		OutputStream out = null;
		InputStream in  = null;
		try {
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/media/get?access_token="+access_token+"&media_id=" + mediaId);
			// 将连接打开并转为httpUrlConnection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 连接
			conn.connect();
			// 设置响应头
			response.setContentType("application/octet-stream; charset=utf-8");
			// 设置文件名
			String suffix = conn.getHeaderField("Content-Disposition").split("=")[1];
			response.setHeader("Content-Disposition",
					"attachment;filename=" + "Cynara-" + suffix.substring(suffix.length() - 10, suffix.length() - 1));
			response.setContentLength(Integer.parseInt(conn.getHeaderField("Content-Length")));
			response.setHeader("Content-Type", conn.getHeaderField("Content-Type"));
			// 构建输出流
			out = response.getOutputStream();
			// 构建输入流 将URL读取到的资源写入输出流
			in = conn.getInputStream();
			byte b[] = new byte[1024];
			int len = 0;
			// 写文件
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			log.info("mediaId:"+mediaId+" 文件下载成功！");
		} catch (Exception e) {
			log.info("mediaId:"+mediaId+" 文件下载失败！"+e);
		}finally{
			// 关闭流
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				log.info("mediaId:"+mediaId+"关闭流失败"+e);
			}
			
		}
	}
}
