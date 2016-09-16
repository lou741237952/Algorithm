package 华为OJ;
import java.util.Scanner;
public class 合法IP{
	public static void main(String[] args){
    	String[] s=new Scanner(System.in).nextLine().split("\\.");
    	for(String str:s){
    		int a=Integer.valueOf(str);
    		if(0>a||a>255){
    			System.out.println("NO");
    			return;
    		} 
    	}
    	System.out.println("YES");
    }
}
