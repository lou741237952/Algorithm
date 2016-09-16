package 华为OJ;

import java.util.Scanner;    
public class 记负均正{    
public static void main(String[] args){    
    Scanner scan=new Scanner(System.in);   
    int num=scan.nextInt();  
    int[] arr=new int[num];  
    int neg=0; double sum=0;  
    for(int i=0;i<=num-1;i++){  
        int temp=scan.nextInt();  
            if(temp<0){  
                neg++;  
                temp=0;  
            }   
            arr[i]=temp;  
            sum+=temp;  
    }  
    if(sum%(num-neg)==0){  
        System.out.print(neg+" "+(int)(sum/(num-neg)));  
    }else{  
         double result=sum/(num-neg);  
    System.out.print(neg+" "+String.format("%.1f", result));  
    }  
    }  
}  
