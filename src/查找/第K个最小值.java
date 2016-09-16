package 查找;
/**
 * 基于快速排序的第K个最小值算法
 * @author lou
 */
import java.io.*;

public class 第K个最小值 {
	private char[] result;
	
	public static void main(String[] args) throws IOException {
		
		new 第K个最小值("abcdefghijklmnopqrstuvwxyz",13);
	}
	
	public 第K个最小值(String str,int k){
		
		this.result=str.toCharArray();
		quicksearch(result,0,result.length-1,k);
		System.out.println(result[k-1]);
	}
	
	public void quicksearch(char[] arr,int left,int right,int k){
		int center=(left+right)/2;
		median(arr,left,center,right);
		if((right-left)<=2){return;}
		
		swap(arr,center,right-1);
		int pivot=right-1;
		int i=left,j=pivot;
		
		while(true){
			while(arr[++i]<arr[pivot]);
			while(arr[--j]>arr[pivot]);
			if(i<j){
				swap(arr,i,j);
			}else{
				break;
			}
		}
		swap(arr,i,pivot);
		if(i<k){
			quicksearch(arr,i+1,right,k-i);
		}
		if(i>k){
			quicksearch(arr,left,i-1,k);
		}
		
		
	}
	
	public void median(char[] arr,int a,int b,int c){
		if(arr[a]>arr[b]){swap(arr,a,b);}
		if(arr[c]<arr[a]){swap(arr,b,c);swap(arr,b,a);}
		if(arr[c]>=arr[a]&&arr[c]<arr[b]){swap(arr,b,c);}
	}
	public void swap(char[] arr,int a,int b){
		char temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
}
