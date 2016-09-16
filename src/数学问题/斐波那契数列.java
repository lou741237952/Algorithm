package 数学问题;
/**
 * 斐波那契数列递归与非递归实现
 * @author lou
 *
 */
public class 斐波那契数列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int sum=new 斐波那契数列().fibonacci_recursion(10);
		int sum=new 斐波那契数列().fibonacci_unrecursion(31);
		System.out.println(sum);

	}
	public int fibonacci_recursion(int n){
		if(n==0){return 0;}
		else if(n==1){return 1;}
		else{
			return fibonacci_recursion(n-1)+fibonacci_recursion(n-2);
		}
	}
	public int fibonacci_unrecursion(int n){
		if(n==0){return 0;}
		else if(n==1){return 1;}
		else{
			int b=0,sum=1;
			for(int i=2;i<=n;i++){
				sum+=b;
				b=sum-b;
			}
			return sum;
		}
	}
}
