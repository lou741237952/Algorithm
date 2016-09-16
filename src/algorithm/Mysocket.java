package algorithm;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Mysocket {
	private Socket s;
	private InputStream in;
	private OutputStream out;
	private InputStreamReader reader;
	private OutputStreamWriter writer;
	private BufferedReader breader;
	private BufferedWriter bwriter;
	private Scanner scan;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new Mysocket();
	}
	
	public Mysocket() throws IOException, InterruptedException{
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println("Client Information:\n      Hostname: "+ip.getHostName()+"\n      IP: "+ip.getHostAddress()+"\n      Port: 8888");

		Myconnect("192.168.229.1",8888);
	}
	
	public void Myconnect(String serverip,int port ) throws IOException, InterruptedException{
		
		this.s=new Socket(serverip,port);
		
		try {
			this.out=s.getOutputStream();
			writer=new OutputStreamWriter(out);
			bwriter=new BufferedWriter(writer);
			this.in=s.getInputStream();
			reader=new InputStreamReader(in);
			breader=new BufferedReader(reader);
			
			System.out.println("\nPlease enter:");
			this.scan=new Scanner(System.in);
			String writestring=scan.nextLine()+"\n";
			bwriter.write(writestring);
			bwriter.flush();
//			等待服务器响应
			System.out.println("\nWaiting for Server to response...\n");
			Thread.sleep(100);
			
			String getm = breader.readLine();
			System.out.println(getm.substring(0, 17)+"\n"+getm.substring(17));
			
			bwriter.close();writer.close();in.close();
			breader.close();reader.close();out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
