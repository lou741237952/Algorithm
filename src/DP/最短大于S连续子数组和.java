package DP;
/**
 * 寻找长度最短且和大于threshold的子数
 * @author lou
 *
 */
public class 最短大于S连续子数组和 {

	public static void main(String[] args) {
		new 最短大于S连续子数组和("1 2 3 4 5 6 1 1 7 2 3");

	}
	public 最短大于S连续子数组和(String str){
		int[] arr=new int[str.length()];
		
		int sum=0; int threshold=8;
		int start=0; int end=0; 
		int start_temp=0; int end_temp=0;
		int length=str.length();
		
		String[] strarr=str.split(" ");			//String变成int[]
		for(int i=0;i<=strarr.length-1;i++){
			arr[i]=Integer.parseInt(strarr[i]);
			System.out.print(arr[i]);
		}
		
		for(;end_temp<=str.length()-1;end_temp++){
			sum+=arr[end_temp]; 
			
			while(sum>=threshold){		//加入新的一个数只要大于阈值就把最左边的循环减去，直到小于阈值
				if(end_temp-start_temp+1<length){
					length=end_temp-start_temp+1;
					start=start_temp;
					end=end_temp;			//保存长度和首尾序号
					}
				 
				sum-=arr[start_temp];
				start_temp++;
			}
		}
		System.out.println("\nthreshold"+threshold+" start"+start+" end"+end+" length"+length);
		
		
	}
	}
	

