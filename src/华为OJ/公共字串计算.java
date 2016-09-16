package 华为OJ;
import java.util.Scanner;  
public class 公共字串计算{  
        public static void main(String[] args){  
            Scanner scan=new Scanner(System.in);  
            String a=scan.next().toLowerCase();  
            String b=scan.next().toLowerCase();  
            int sum=0;  
            for(int i=0;i<=a.length()-1;i++){  
                for(int n=i;n<=a.length()-1;n++){  
                    if(b.contains(a.substring(i, n+1))){  
                        sum=Math.max(sum, n-i+1);  
                    }  
                }  
            }  
            System.out.println(sum);  
        }  
}  
