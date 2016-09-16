package 华为OJ;

import java.util.Scanner;  
public class 句子逆序{  
    public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
        String[] d=scan.nextLine().split(" +");  
        for(int i=d.length-1;i>=0;i--){  
            System.out.print(d[i]);  
            if(i!=0)System.out.print(" ");  
        }  
    }  
}  