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

//���������൱��tomcat
public class WebServer {

	public static void main(String[] args) throws Throwable {
		//socket��̣��̱߳��
		//�������������ͻ��˰���Ϣ����9090�˿�
		ServerSocket serverSocket=new ServerSocket(9090);
		System.out.println("������������");
		//��ͣ�����ͻ����Ƿ񷢹�������
		while(true) {
			//���տͻ��˷�����������
			Socket socket=serverSocket.accept();
			//ÿ��һ���û�����һ���߳�
			HttpThread httpThread=new HttpThread(socket);
			httpThread.start();
		}
	}
	//�ڲ���
	//�߳�
	static class HttpThread extends Thread{
		Socket socket;//�����һ���ͻ��˵�����
		public HttpThread(Socket socket) {
			this.socket=socket;
		}
		@Override
		public void run() {
			try {
				//���������������������
				//�õ�������InputStream
				InputStream inputStream=socket.getInputStream();
				//��������ת��InputStreamReader
				InputStreamReader inputStreamReader=new 
						InputStreamReader(inputStream);
				//ת��bufferedReader
				BufferedReader bufferedReader=new 
						BufferedReader(inputStreamReader);
				//������
				String requestLine =bufferedReader.readLine();
				System.out.println(requestLine);
				//GET /register HTTP/1.1
				//stringTokenizer����ȡ�ַ����е�����
				StringTokenizer stringTokenizer=new StringTokenizer(requestLine);
				String requestMethod=stringTokenizer.nextToken();				
				System.out.println(requestMethod);
				
				String url=stringTokenizer.nextToken();	
				System.out.println(url);
				//����dispatcherServlet
				HttpServletRequest request=new HttpServletRequest();
				request.setUrl(url);
				
				DispatcherServlet dispatcherServlet=new DispatcherServlet();
				HttpServletResponse response=dispatcherServlet.doDispatch(request);
				System.out.println(response.getResponseBody());
				
				//�ѽ�����ظ������
				//1,��Ӧ��
				String responseLine="HTTP/1.1 200 OK \r\n";
				//2,��Ӧͷ
				StringBuilder stringBuilder=new StringBuilder();
				stringBuilder.append("Context-Type:text/html\r\n");
				//�����������Ӧ��������Ƕ��ٸ��ֽ�
				stringBuilder.append("Context-Length:"
				+response.getResponseBody().getBytes().length+"\r\n");
				stringBuilder.append("\r\n");
				//3,��Ӧ��
				OutputStream outputStream=socket.getOutputStream();
				//������Ӧ��
				outputStream.write(responseLine.getBytes());
				//������Ӧͷ
				outputStream.write(stringBuilder.toString().getBytes());
				//������Ӧ��
				outputStream.write(response.getResponseBody().getBytes());
				outputStream.flush();
				outputStream.close();
			} catch (Throwable e) {
				// TODO: handle exception
			}
		}
	}
}
