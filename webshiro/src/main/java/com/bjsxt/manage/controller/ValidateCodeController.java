package com.bjsxt.manage.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidateCodeController {
	@RequestMapping("validCode")
	public void validateCode(HttpServletResponse response, HttpServletRequest req) throws IOException {
		// File file = new
		// File(req.getServletContext().getRealPath("/WEB-INF/images"),"a.png");
		// //获取响应流对象
		// ServletOutputStream os = response.getOutputStream();
		// os.write(FileUtils.readFileToByteArray(file));
		// os.flush();
		// os.close();
/*
		//创建图片
				BufferedImage image=new BufferedImage(150, 45, BufferedImage.TYPE_INT_RGB);
				//创建画板
				Graphics2D graph=image.createGraphics();
				//设置画笔颜色
				graph.setColor(Color.WHITE);
				//填充矩形区域
				graph.fillRect(0, 0, 150, 45);
				
				//创建字体
				graph.setFont(new Font("宋体", Font.ITALIC|Font.BOLD, 23));
				
				// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
				StringBuffer code=new StringBuffer();
				Random random=new Random();
				
				int red=0,yellow=0,blue=0;
				//大写A-Z 65-90  小写a-z 97-122
				   char[] codes = {  '0','1','2','3','4','5','6','7','8','9',
			                         'A','B','C','D','E','F','G','H','I','J',
			                         'K','L','M','N','O','P','Q','R','S','T',
			                         'U','V','W','X','Y','Z','a','b','c','d',
			                         'e','f','g','h','i','j','k','l','m','n',
			                         'o','p','q','r','s','t','u','v','w','x',
			                         'y','z'};//62个
				char[] codes = {'1','2','3','4'};
				for(int i=0;i<4;i++){
					int n=random.nextInt(62);
					char num=codes[n];
					code.append(""+num);
					//设定颜色， 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
					red=random.nextInt(255);
					yellow=random.nextInt(255);
					blue=random.nextInt(255);
					// 用随机产生的颜色将验证码绘制到图像中。
					graph.setColor(new Color(red, yellow, blue));
					graph.drawString(""+num, i*35+10, 32+(random.nextInt(11)-5));
				}
				//画线
				for (int i = 0; i < 2; i++) {
					red=random.nextInt(256);
					yellow=random.nextInt(256);
					blue=random.nextInt(256);
					graph.setColor(new Color(red, yellow, blue));
					graph.drawLine(0, random.nextInt(46), 150, random.nextInt(46));
				}
				//把验证码存放到Session中
				req.getSession().setAttribute("validateCode", code.toString());
				ServletOutputStream os = response.getOutputStream();
				ImageIO.write(image, "jpeg", os);*/
		// 创建图片
		BufferedImage image = new BufferedImage(180, 40, BufferedImage.TYPE_INT_RGB);
		// 创建画板
		Graphics2D grap = image.createGraphics();
		//设置画笔颜色
		grap.setColor(Color.WHITE);
		//填充矩形区域
		grap.fillRect(0, 0, 180, 40);
		
		
		//存放颜色的数组
		Color[] cs = new Color[]{Color.RED,Color.YELLOW,Color.BLUE,Color.PINK,Color.gray,Color.GREEN};
		//生成随机数
		StringBuffer sf = new StringBuffer();
		Random random =new Random();
		//设置字体样式
		grap.setFont(new Font("宋体", Font.ITALIC|Font.BOLD, 20));
		for (int i = 0; i < 4; i++) {
			//0-9随机数
			int nextInt = random.nextInt(10);
			sf.append(""+nextInt);
			//设定颜色
			grap.setColor(cs[random.nextInt(cs.length)]);
			//写字
			grap.drawString(""+nextInt, i*45+10, 30+(random.nextInt(11)-5));
		}
		
		//画线
		for (int i = 0; i < 2; i++) {
			grap.setColor(cs[random.nextInt(cs.length)]);
			grap.drawLine(0, random.nextInt(41), 180, random.nextInt(41));
		}
		//把验证码存放到Session中
		req.getSession().setAttribute("validateCode", sf.toString());
		//获取响应流
		ServletOutputStream os = response.getOutputStream();
		//把第一个参数转换为第二个参数类型,并放入到第三个参数中
		ImageIO.write(image, "jpg", os);
	}
}
