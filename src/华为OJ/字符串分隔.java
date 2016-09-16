package 华为OJ;

import java.util.Scanner;

public class 字符串分隔 {
	 public static void main(String[] args){  
	        Scanner scan=new Scanner(System.in);  
	        String a=scan.next();  
	        String b=scan.next();  
	        字符串分隔 m=new 字符串分隔();  
	        m.print(a);  
	        System.out.println();  
	        m.print(b);  
	    }  
	    void print(String s){  
	        if(s.length()<=8){  
	            System.out.print(s);  
	            for(int i=1;i<=8-s.length();i++){  
	                System.out.print(0);  
	            }  
	        }else{  
	            for(int i=0;i<=s.length()-1;i++){  
	                System.out.print(s.charAt(i));  
	                if((i+1)%8==0){  
	                    System.out.println();  
	                }  
	            }  
	            int reminder=s.length()%8;  
	            if(reminder!=0){  
	                for(int i=1;i<=8-reminder;i++){  
	                    System.out.print(0);  
	                }  
	            }  
	              
	        }  
	    }  
}
