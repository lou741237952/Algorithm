package 华为OJ;
import java.util.Scanner;  
public class 输出单向链表中倒数第k个结点{  
    public static void main(String[] args){  
    Scanner scan=new Scanner(System.in);  
        int num=scan.nextInt();  
        ListNode header=new ListNode(0);  
        ListNode save=header;  
        for(int i=0;i<=num-1;i++){  
            header.next=new ListNode(scan.nextInt());  
            header=header.next;  
        }  
       int remove=scan.nextInt();  
         
        for(int i=0;i<=num-remove-1;i++){  
            save=save.next;  
        }  
        System.out.println(save.value);  
    }  
}  
class ListNode{  
    int value;  
    ListNode next;  
    ListNode(int k){  
        this.value=k;  
    }  
} 