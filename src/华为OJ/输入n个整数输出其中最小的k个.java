package 华为OJ;
import java.util.Arrays;  
import java.util.Scanner;  
public class 输入n个整数输出其中最小的k个{  
    public static void main(String[] args){  
    Scanner scan=new Scanner(System.in);  
        int num=scan.nextInt();  
        int cut=scan.nextInt();  
        int[] arr=new int[num];  
        for(int i=0;i<=num-1;i++){  
            arr[i]=scan.nextInt();  
        }  
        Arrays.sort(arr);  
         
        StringBuilder sb=new StringBuilder();  
        for(int i=0;i<=cut-1;i++){  
              
            sb.append(Integer.toString(arr[i])+" ");  
        }  
        System.out.print(sb.toString().trim());  
}         
}  