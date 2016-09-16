package algorithm;
/**
 * 递归办法实现字符对半交换
 * @author lou
 *
 */
public class 字符对半交换 {

	public static void main(String[] args) {
				String input="何操死楼";
				System.out.println("输入: "+input);
				new 字符对半交换(input);
		
	}
	
	public 字符对半交换(){}
	
	public 字符对半交换(String str){
		char[] result=str.toCharArray();
		reversestring(result,0,str.length()-1);
		System.out.println("输出: "+String.valueOf(result));
	}
	
	public void reversestring(char[] list,int left,int right){
		if(left==right){
			return;
		}
		else{
			int center=(left+right)/2;
			reversestring(list,left,center);		//左右分别交换
			reversestring(list,center+1,right);
			halfswap(list,left,right);
			
		}
	}
	public void halfswap(char[] list,int a,int b){
		int cen=(a+b)/2;
		int n; char temp;
		
		if((b-a)%2==0){           //奇数
			for(n=a;n<=cen-1;n++){
				temp=list[n];
				list[n]=list[cen+n-a+1];
				list[cen+n-a+1]=temp;
			}
			for(int i=0;i<=b-cen-1;i++){
				temp=list[cen+i];
				list[cen+i]=list[cen+i+1];
				list[cen+i+1]=temp;
			}
		}
		else{					//偶数
			for(n=a;n<=cen;n++){
				temp=list[n];
				list[n]=list[cen+n-a+1];
				list[cen+n-a+1]=temp;
			}
		}
	}	

}
