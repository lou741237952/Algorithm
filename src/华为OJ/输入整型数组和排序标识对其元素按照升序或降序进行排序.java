package 华为OJ;

import java.util.Arrays;
import java.util.Scanner;

public class 输入整型数组和排序标识对其元素按照升序或降序进行排序 {
	public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
        int num=scan.nextInt();  
        int[] m=new int[num];  
        for(int i=0;i<=m.length-1;i++){  
            m[i]=scan.nextInt();  
        }  
        int tag=scan.nextInt();  
          
        Arrays.sort(m);  
          
        if(tag==0){  
            for(int i=0;i<=m.length-1;i++){  
                System.out.print(m[i]);  
                if(i!=m.length-1) System.out.print(" ");  
            }  
            return;  
        }  
        if(tag==1){  
            for(int i=0;i<=m.length-1;i++){  
                System.out.print(m[m.length-1-i]);  
                if(i!=m.length-1) System.out.print(" ");  
            }  
            return;  
        }  
    }  
}
