package 华为OJ;
import java.util.Scanner;  
public class 中级单词倒排{  
        public static void main(String[] args){  
            Scanner scan=new Scanner(System.in);  
            String[] str=scan.nextLine().split("[^A-Za-z]");  
            for(int i=0;i<=str.length-1;i++){  
                System.out.print(str[str.length-1-i]);  
                if(i!=str.length-1)System.out.print(" ");  
            }  
        }  
}  