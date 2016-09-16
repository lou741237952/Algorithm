package DP;
/**
 * 卡特兰数
 * @author lou
 *
 */
public class 卡特兰数 {
	private int[] result;
	
	public static void main(String[] args) {
		new 卡特兰数(3);
		
	}
	public 卡特兰数(int n){
		
		if(n==0){System.err.println("Error");return;}
		
		this.result=new int[n+1];
		
		caculate(n);
		System.out.println(result[n]);
	}
	
	private void caculate(int n){
		result[0]=1;
		result[1]=1;
		
		if(n==1){return;}
		
		for(int i=2;i<=n;i++){			//动态规划      result[i]表示i个数有多少出栈方式
			for(int m=0;m<=i-1;m++){	//m为某个定数出现在出栈序列的第几个位置
				result[i]+=(result[m]*result[i-m-1]);
				
			}
		}
	}
}
