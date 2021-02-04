
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �����������֧��Ⱥ��,�൱��openfire
 * 
 * ��һ�����û�������һ���߳�,�Ὠһ��socket���ӣ�
 * 
 * socket����ֻ�����û��˳���ʱ��Ż�رա�
 * @author pjy
 *
 */
public class SocketServer {
	//ÿ����ֻ����һ�ݣ�
	//Eclipse run as -->java Application
	
	//�������\���п��������\����͹���
	//�򿪻�ر�windows���ܹ���telnet�ͻ���
	
	//����ͬѧ��dos��ִ��
	//telnet �鳤ip 15898
	//0-1023���˿ں����ֵ65535
	
    private List<Socket> socketList = new ArrayList<Socket>();
    private ServerSocket server = null;
    private ExecutorService threadPool = null; //thread pool
    
    public static void main(String[] args) {
        new SocketServer();
    }
    public SocketServer() {
        try {
        	//����пͻ��˷���Ϣ��15898����˿ڣ�
        	//����ϵͳ�����Ϣ�����������������
            server = new ServerSocket(15898);
            threadPool = Executors.newCachedThreadPool();  //create a thread pool
            System.out.println("server start ...");
            //socketClient����������ĳһ���ͻ��˵�����            
            Socket socketClient = null;
            while(true) {
            	//�ͻ��˸����Ƿ������˽�������֮��
            	//����socketClient����
                socketClient = server.accept();
                
                socketList.add(socketClient);
              //  System.out.println("��"+mList.size()+"������ ");
                System.out.println("������ ");
                threadPool.execute(new Service(socketClient)); //start a new thread to handle the connection
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    class Service implements Runnable {
            private Socket socketClient;
            private BufferedReader in = null;
            private String msg = "";
            
            public Service(Socket socketClient) {
                this.socketClient = socketClient;
                try {
                    in = new BufferedReader(new InputStreamReader(
                    		socketClient.getInputStream()));
                    
                    msg = "�ͻ���ip:" +this.socketClient.getInetAddress() + "�ͻ��˸���:"
                        +socketList.size()+"�߳�id:"+Thread.currentThread().getId();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    System.out.println("�߳�id="+Thread.currentThread().getId()+",�ͻ���ip��"+socketClient.getInetAddress()+",socket��"+socketClient.toString());

                    while(true) {
                        if((msg = in.readLine())!= null) {
                            if(msg.equals("exit")) {
                                System.out.println("�пͻ����˳�");
                                socketList.remove(socketClient);
                                in.close();
                                msg = "user:" + socketClient.getInetAddress()
                                    + "exit total:" + socketList.size();
                                socketClient.close();
                               
                                break;
                            } else {
                            	//״̬��|��Ϣ����|��Ϣjson����
                                msg = socketClient.getInetAddress() + ":" + msg;
                               System.out.println("sever �յ�"+msg);
                             //socket�������ڴ��С��ͻ��˲������󣬷�������Ҳ����������ͻ��˷�����
                               //http���ص��Ǳ����ǿͻ����ȷ����󣬷������˲��ܷ������ݡ�
                               
                               int socketClinetNumber =socketList.size();
                               //�����еĿͻ��˷�����,˵��1������ 2����Ⱥ��
                               for (int index = 0; index < socketClinetNumber; index ++) {
                                   //Socket����һ��ip[tcp[msg]]
                            	   Socket socketClient = socketList.get(index);
                                   PrintWriter pout = null;
                                   try {
                                       pout = new PrintWriter(new BufferedWriter(
                                               new OutputStreamWriter(
                                            		   socketClient.getOutputStream())),true);
                                       pout.println(msg);
                                   }catch (IOException e) {
                                       e.printStackTrace();
                                   }
                               }
                           
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
          
           
        }    
}