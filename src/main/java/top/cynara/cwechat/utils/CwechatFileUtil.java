package top.cynara.cwechat.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
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
	public static void wechatFileDownload(HttpServletResponse response,HttpServletRequest request, String access_token,String mediaId) {
		OutputStream out = null;
		InputStream in  = null;
		try {
			//判断这个里面有没有这个文件
			String path =  request.getSession().getServletContext().getRealPath("/WEB-INF/file");
			String filename = HashUtil.getShaHash(mediaId, mediaId);
			File f = new File(path);
			String[] filenames  = f.list();
			if(filenames.length>0){
				for (int i = 0; i < filenames.length; i++) {
					//这种情况是在文件夹中包含此文件
					if(filenames[i].contains(filename)){
						f = new File(path+"/"+filenames[i]);
						// 设置响应头
						response.setContentType("application/octet-stream; charset=utf-8");
						response.setHeader("Content-Disposition",
								"attachment;filename=" + "Cynara-" + filenames[i]);
						response.setContentLength(Integer.parseInt(f.length()+""));
						out = response.getOutputStream();
						in = new FileInputStream(f);
						byte b[] = new byte[1024];
						int len = 0;
						// 写文件
						while ((len = in.read(b)) != -1) {
							out.write(b, 0, len);
						}
						out.close();
						in.close();
						return;
					}
				}
			}
			URL url = new URL("https://api.weixin.qq.com/cgi-bin/media/get?access_token="+access_token+"&media_id=" + mediaId);
			// 将连接打开并转为httpUrlConnection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 连接
			conn.connect();
			// 设置文件名
			String suffix = conn.getHeaderField("Content-Disposition");
			if(suffix!=null){
				suffix = suffix.split("=")[1];
				suffix = suffix.substring(1, suffix.length() - 1);
				filenames = suffix.split("\\.");
			}else{
				return ;
			}
			response.setContentType("application/octet-stream; charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + "Cynara-" + filename+"."+filenames[1]);
			response.setContentLength(Integer.parseInt(conn.getHeaderField("Content-Length")));
			response.setHeader("Content-Type", conn.getHeaderField("Content-Type"));
			f = new File(path+"/"+filename+"."+filenames[1]);
			out = new FileOutputStream(f);
			// 构建输入流 将URL读取到的资源写入输出流
			in = conn.getInputStream();
			byte b[] = new byte[1024];
			int len = 0;
			// 写文件
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			out.close();
			in.close();
			//将文件写到客户端 提供下载
			out  = response.getOutputStream();
			in = new FileInputStream(f);
			while((len = in.read(b))!=-1){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
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
