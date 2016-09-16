package 华为OJ;
import java.util.Scanner;  
import java.util.Arrays;  
public class 图片整理{  
    public static void main(String[] args){  
        char[] arr=new Scanner(System.in).nextLine().toCharArray();  
        Arrays.sort(arr);  
        System.out.println(new String(arr));  
    }  
}  
