package 华为OJ;
import java.util.Scanner;  
public class 字符串匹配{  
        public static void main(String[] args){  
            Scanner scan=new Scanner(System.in);  
            String str=scan.next();  
            String test=scan.next();  
            for(int i=0;i<=str.length()-1;i++){  
                if(!test.contains(Character.toString(str.charAt(i)))){  
                    System.out.println(false);  
                    return;  
                }  
            }  
            System.out.println(true);  
        }  
}  
