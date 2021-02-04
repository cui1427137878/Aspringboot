package org.springmvc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.http.HttpServletRequest;
import javax.http.HttpServletResponse;

//服务器，相当于tomcat
public class WebServer {

	public static void main(String[] args) throws Throwable {
		//socket编程，线程编程
		//开启服务器，客户端把信息发给9090端口
		ServerSocket serverSocket=new ServerSocket(9090);
		System.out.println("服务器启动了");
		//不停监听客户端是否发过来请求
		while(true) {
			//接收客户端发过来的请求
			Socket socket=serverSocket.accept();
			//每来一个用户启动一个线程
			HttpThread httpThread=new HttpThread(socket);
			httpThread.start();
		}
	}
	//内部类
	//线程
	static class HttpThread extends Thread{
		Socket socket;//代表和一个客户端的连接
		public HttpThread(Socket socket) {
			this.socket=socket;
		}
		@Override
		public void run() {
			try {
				//接收浏览器发过来的数据
				//得到输入流InputStream
				InputStream inputStream=socket.getInputStream();
				//把输入流转成InputStreamReader
				InputStreamReader inputStreamReader=new 
						InputStreamReader(inputStream);
				//转成bufferedReader
				BufferedReader bufferedReader=new 
						BufferedReader(inputStreamReader);
				//请求行
				String requestLine =bufferedReader.readLine();
				System.out.println(requestLine);
				//GET /register HTTP/1.1
				//stringTokenizer作用取字符串中的内容
				StringTokenizer stringTokenizer=new StringTokenizer(requestLine);
				String requestMethod=stringTokenizer.nextToken();				
				System.out.println(requestMethod);
				
				String url=stringTokenizer.nextToken();	
				System.out.println(url);
				//调用dispatcherServlet
				HttpServletRequest request=new HttpServletRequest();
				request.setUrl(url);
				
				DispatcherServlet dispatcherServlet=new DispatcherServlet();
				HttpServletResponse response=dispatcherServlet.doDispatch(request);
				System.out.println(response.getResponseBody());
				
				//把结果返回给浏览器
				//1,响应行
				String responseLine="HTTP/1.1 200 OK \r\n";
				//2,响应头
				StringBuilder stringBuilder=new StringBuilder();
				stringBuilder.append("Context-Type:text/html\r\n");
				//告诉浏览器响应体的内容是多少个字节
				stringBuilder.append("Context-Length:"
				+response.getResponseBody().getBytes().length+"\r\n");
				stringBuilder.append("\r\n");
				//3,响应体
				OutputStream outputStream=socket.getOutputStream();
				//返回响应行
				outputStream.write(responseLine.getBytes());
				//返回响应头
				outputStream.write(stringBuilder.toString().getBytes());
				//返回响应体
				outputStream.write(response.getResponseBody().getBytes());
				outputStream.flush();
				outputStream.close();
			} catch (Throwable e) {
				// TODO: handle exception
			}
		}
	}
}
