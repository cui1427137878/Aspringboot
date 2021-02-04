package com.tedu.sp02_mail.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//框架自动创建对象
public class MailController {
	
	//发邮件的对象
	//以前都是通过new来创建对象
	//让框架给我们一个对象
	@Autowired
	JavaMailSender javaMailSender;
	//subject邮件标题  text邮件正文
	public void sendMail(String subject,String text) {
		//创建邮件
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		//设置收件人
		mailMessage.setTo("1111@qq.com");
		//设置发件人
		mailMessage.setFrom("1111@qq.com");
		//设置邮件标题
		mailMessage.setSubject(subject);
		//设置邮件正文
		mailMessage.setText(text);
		//发送邮件
		javaMailSender.send(mailMessage);
	}
	//发个普通邮件
	@RequestMapping("/send1")
	//找个Application run as 启动服务器，
	//控制台看到 tomcat started on port 30001
	//http://localhost:30001/send1
	public String send1() {
		sendMail("测试", "测试");
		return "发送邮件完成，到qq邮箱收邮件";
	}
	
	//出异常，发邮件
	@RequestMapping("/send2") //localhost:30001/send2
	public String send2() {
		try {
			int n=10/0;//出异常
		} catch (Exception e) {
			//程序员看不到异常信息
			//e.printStackTrace();
			//把异常信息转成字符串
			StringWriter stringWriter=new StringWriter();
			PrintWriter printWriter=new PrintWriter(stringWriter);
			//异常信息输出到printWrite,输出到了stringWriter
			e.printStackTrace(printWriter);
			sendMail("异常信息", stringWriter.toString());			
		}
		return "收邮件";
	}

}
