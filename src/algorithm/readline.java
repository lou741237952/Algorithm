package algorithm;
import java.io.*;

public class readline {

	public static void main(String[] args) throws IOException {
		new readline().typereadline();
	}
	public readline() throws IOException{
//		读取文件内容
		File file=new File("C:\\Users\\lou\\Desktop\\lou_read.txt");
		FileInputStream fis=new FileInputStream(file);
		InputStreamReader rd=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(rd);
		String sb=null;
		while((sb=br.readLine())!=null){
			System.out.println(sb+"\n\n");
		}
		fis.close();rd.close();br.close();
		
	}
	public void typereadline() throws IOException{
//		读取输入内容
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(read);
		System.out.println("请一次性输入写出字符串，回车键结束。");
		String str=null;
		
		if((str=br.readLine())!=null){
			System.out.println("User inputs string: "+str+"\nSaving the string now!");	
		}
		read.close();br.close();
		System.out.println("Input has finished.");
//		输出内容到文件汇总
		File file=new File("C:\\Users\\lou\\Desktop\\lou_write.txt");
		if(file.exists()){
			System.out.println("File is already existed.");
			}else{
			file.createNewFile();
			System.out.println("File(lou_write.txt) is created.");
			}
		
//		FileOutputStream fo=new FileOutputStream(file);
//		写出字符串到文件(方法一)
//		OutputStreamWriter ow=new OutputStreamWriter(fo);
//		BufferedWriter bw=new BufferedWriter(ow);
//		bw.write(str,0,str.length());
//		bw.flush();bw.close();ow.close();
		
//		写入文件(方法二)
		FileWriter fo=new FileWriter(file);
		PrintWriter ps=new PrintWriter(fo,true);
		ps.println(str);ps.flush();
		fo.close();ps.close();
		System.out.println("String is already written.");
		
		
		
	}
}

