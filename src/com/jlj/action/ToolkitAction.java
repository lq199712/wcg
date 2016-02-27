package com.jlj.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
@Component("toolkitAction")
@Scope("prototype")
public class ToolkitAction extends ActionSupport implements 
		SessionAware,ServletResponseAware,ServletRequestAware {
	Map<String,Object> session;
	HttpServletRequest request;
	HttpServletResponse response;
	public String validateCode() throws IOException{
		response.setContentType("image/jpeg;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//设置页面不缓存
		response.setHeader("Param", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("Expires", 0);
		//设置图片的高和宽
		int width=80;
		int height=40;
		//创建内存缓冲图片对象
		BufferedImage bimage=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		//获取图片对象的上下文(画笔)
		Graphics gh=bimage.getGraphics();
		//填充背景
		gh.setColor(getColor());
		gh.fillRect(0, 0, width, height);
		//随机生成5条干扰线
		Random ran=new Random();
		for(int i=0;i<5;i++)
		{
			//第一个点的位置
			int x1=ran.nextInt(80);
			int y1=ran.nextInt(40);
			//第二个点的位置
			int x2=ran.nextInt(80);
			int y2=ran.nextInt(40);
			gh.setColor(getColor());
			gh.drawLine(x1, y1, x2, y2);
		}
		String scode="0123456789";//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789改全数字
		//存储生成的随机验证码
		String code="";
		for(int i=0;i<4;i++)
		{
			String ch=String.valueOf(scode.charAt(ran.nextInt(scode.length())));
			//将生成的字符拼在code字符串中
			code+=ch;
			//设置gh的颜色
			gh.setColor(Color.BLACK);
			//设置字体
			gh.setFont(new Font("Times New Roman",Font.ITALIC,22));
			//将字写在图片上
			gh.drawString(ch,i*13+10,26);
		}
		session.put("code",code);
		//生成图像
		gh.dispose();
		//创建二进制的输出流
		ServletOutputStream sos=response.getOutputStream();
		//创建图形对象
		JPEGImageEncoder jpeg=JPEGCodec.createJPEGEncoder(sos);
		jpeg.encode(bimage);
		return NONE;
	}
	public Color getColor()
	{
		int r,g,b;
		Random rad=new Random();
		r=rad.nextInt(255);
		g=rad.nextInt(255);
		b=rad.nextInt(255);
		Color cor=new Color(r,g,b);
		return cor;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response=response;
	}
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	

}
