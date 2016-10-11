package top.cynara.cwechat.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName ValidateCode
 * @Description 验证码
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月8日 下午1:45:11
 * @version V1.0
 */
public class ValidateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 60;
		int height = 32;
		//create the image
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// set the background color
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// draw the border
		g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
		g.drawRect(0, 0, width - 1, height - 1);
		// create a random instance to generate the codes
		Random rdm = new Random();
		String hash1 = Integer.toHexString(rdm.nextInt());
		// make some confusion
		for (int i = 0; i < 50; i++) {
			int x = rdm.nextInt(width);
			int y = rdm.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}
		// generate a random code
		String capstr = hash1.substring(0, 4);
		//将生成的验证码存入session
		request.getSession().setAttribute("validateCode", capstr);
		g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
		g.setFont(new Font("Candara", Font.BOLD, 24));
		g.drawString(capstr, 8, 24);
		g.dispose();
		//输出图片
		response.setContentType("image/jpeg");
		OutputStream strm = response.getOutputStream();
		ImageIO.write(image, "jpeg", strm);
		strm.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
