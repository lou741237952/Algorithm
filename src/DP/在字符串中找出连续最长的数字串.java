package DP;
import java.util.Scanner;  
public class 在字符串中找出连续最长的数字串{  
    public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
        String test=scan.nextLine();  
        if(test.equals("")){  
            System.out.println();  
            return;  
        }  
        int count=0,temp=0;int b=0;  
        for(int i=0;i<=test.length()-1;i++){  
            if(test.charAt(i)>='0'&&test.charAt(i)<='9'){  
                temp++;  
                if(temp>count){  
                    count=temp;  
                    b=i-count+1;  
                }  
            }else{  
                temp=0;  
            }  
        }  
        if(count==0){  
            System.out.println(0);  
            return;  
        }  
        for(int i=0;i<=count-1;i++){  
            System.out.print(test.charAt(b+i));  
        }  
          
        System.out.println(","+count);  
    }  
}  