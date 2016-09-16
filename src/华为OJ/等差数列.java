package 华为OJ;
import java.util.Scanner;  
public class 等差数列{  
    public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
        String n=scan.nextLine().trim();  
        new 等差数列().execute(n);  
    }  
    void execute(String n){  
        if(n.matches("^[1-9][0-9]*$")){  
            System.out.println((3*Integer.parseInt(n)+1)*Integer.parseInt(n)/2);  
              
        }else{  
            System.out.println(-1);  
        }                 
    }  
}  