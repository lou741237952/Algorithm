package algorithm;
import java.io.*;
import java.net.*;

public class Myserversocket {
	private ServerSocket serversocket;
	private Socket socket;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new Myserversocket();
	}
	
	public Myserversocket() throws IOException, InterruptedException{
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println("Server Information:\n      Hostname: "+ip.getHostName()+"\n      IP: "+ip.getHostAddress()+"\n      Port: 8888");
		serversocket=new ServerSocket(8888);
		
		
//循环监听，接受请求创建一个线程
		
			System.out.println("\nWaiting for client..."); 
			socket=serversocket.accept();
			MyserversocketThread myss=new MyserversocketThread(socket);
				myss.start();
			}
}

class MyserversocketThread extends Thread{
	private Socket s=null;
	private BufferedReader breader;
	private PrintWriter bwriter;
	private String str;
	
	public MyserversocketThread(Socket s){
		super("MyserverSocket");
		this.s=s;
		
	}
	public void run(){
		
		try {
			
			breader=new BufferedReader(new InputStreamReader(s.getInputStream()));
			bwriter=new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
	
			str = breader.readLine(); 
			bwriter.println("Ehco from Server:"+str);
			System.out.println("\nUser entered: "+str);

			bwriter.flush();
			bwriter.close();
			breader.close();
			s.close();
			System.out.println("\nServer closed.");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
	
}
