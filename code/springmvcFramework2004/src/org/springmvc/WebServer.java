package org.springmvc;

import javax.http.HttpServletRequest;
import javax.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args) throws  Throwable{
//接收浏览器发过来的请求，用bio
        ServerSocket serverSocket=new ServerSocket(9080);
        System.out.println("web服务器启动成功");
        while (true){
            //接收浏览器的连接请求
            Socket socket=serverSocket.accept();
            //启动线程
            HttpThread httpThread=new HttpThread(socket);
            httpThread.start();
        }
    }
    //内部类
    static class  HttpThread extends  Thread{
        Socket socket;
        public HttpThread(Socket socket){
            this.socket=socket;
        }
        @Override
        public void run() {
            try {
                //接收浏览器发过来的数据
                InputStream inputStream=socket.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                //读取http的请求行
                String requestLine=bufferedReader.readLine();
                System.out.println(requestLine);
                // get /login http1.1
                String[] array=requestLine.split("\\ ");
                System.out.println(array[1]);

                //创建httpServletRequest
                HttpServletRequest request=new HttpServletRequest();
                request.setUrl(array[1]);
                //把请求交给dispatcherServlet处理
                DispatcherServlet dispatcherServlet=new DispatcherServlet();
                HttpServletResponse response=dispatcherServlet.doDispatch(request);
                //接收controller返回的结果
                String responseBody=response.getResponseBody();
                System.out.println(responseBody);

                //把结果返回给浏览器
                //1,响应行
                String responseLine="HTTP/1.1 200 ok\r\n";
                //2,响应头
                StringBuilder stringBuilder=new StringBuilder();
                stringBuilder.append("Content-Type:text/html\r\n");
                stringBuilder.append("Content-Length:"
                        +responseBody.getBytes().length+"\r\n");
                stringBuilder.append("\r\n");
                //3,响应体
                OutputStream outputStream=socket.getOutputStream();
                outputStream.write(responseLine.getBytes());
                outputStream.write(stringBuilder.toString().getBytes());
                outputStream.write(responseBody.getBytes());

            }catch (Throwable e){
                e.printStackTrace();
            }

        }
    }
}
