package 华为OJ;

import java.util.Scanner;  
import java.util.HashSet;  
public class 字符个数统计{  
    public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
        String test=scan.nextLine();  
        HashSet<Character> set=new HashSet<Character>();  
        for(int i=0;i<=test.length()-1;i++){  
            if(test.charAt(i)>=0&&test.charAt(i)<=127)set.add(test.charAt(i));  
        }  
        System.out.println(set.size());  
    }  
}  