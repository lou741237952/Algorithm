package algorithm;
import java.util.Scanner;   
public class 字符串通配符{  
    public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
        String test=scan.next().replace("?", ".");  
        System.out.println(scan.next().matches(test));  
    }  
}  
