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
import javax.xml.ws.http.HTTPBinding;

//实现tomcat的核心功能
public class WebServer {

	public static void main(String[] args) throws Throwable{
		//监听端口号
		ServerSocket serverSocket=new ServerSocket(8080);
		System.out.println("webServer运行了");
		while(true) {
			Socket socket=serverSocket.accept();
			HttpRequestThread thread=new HttpRequestThread(socket);
			thread.start();
		}

	}
	static class HttpRequestThread extends Thread{
		Socket socket;
		
		public HttpRequestThread(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			//接收浏览器发过来的请求
			try {
				InputStream inputStream=socket.getInputStream();
				InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
				BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
				String requestLine=bufferedReader.readLine();
				System.out.println(requestLine);
				// get /login
				//分词，
				StringTokenizer stringTokenizer=new StringTokenizer(requestLine);
				String requestMethod=stringTokenizer.nextToken();
				System.out.println("requestMethod="+requestMethod);
				String url=stringTokenizer.nextToken();
				System.out.println("url="+url);
				
				//把浏览器发过来的请求交给dispatcherServlet
				HttpServletRequest request=new HttpServletRequest();
				request.setUrl(url);
				
				DispatcherServlet dispatcherServlet=new DispatcherServlet();
				HttpServletResponse response=dispatcherServlet.doDispatch(request);

				System.out.println("controller执行的结果:"+response.getResponseBody());
			//把controller的结果返回给浏览器
				//响应行
				String responseLine="HTTP/1.1 200 ok \r\n";
				
				//响应头
				StringBuilder stringBuilder=new StringBuilder();
				stringBuilder.append("Content-Type:text/html\r\n");
				String responseBody=response.getResponseBody();
				stringBuilder.append("Content-Length:"+responseBody.length()+"\r\n");
				stringBuilder.append("\r\n");
				//响应体
				OutputStream outputStream=socket.getOutputStream();
				outputStream.write(responseLine.getBytes());
				outputStream.write(stringBuilder.toString().getBytes());
				outputStream.write(responseBody.getBytes());
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

}
