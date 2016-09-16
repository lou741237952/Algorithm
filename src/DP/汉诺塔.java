package DP;
/**
 * f(n,a,b) 表示把a碟子上面的n块转移到b碟子上面

三个碟子编号abc 令S=a+b+c;
f(n,a,b)={	f(n-1,a,S-a-b);
		f(1,a,b);
		f(n-1,S-a-b,b);
	}	
设三个堆栈ABC对应abc三个序号
初始条件f(1,a,b)={
		B.push(A.pop());		
		}
 * @author lou
 *
 */
public class 汉诺塔 {
	myStack<String> stack0,stack1,stack2;
	myStack<String>[] stackarr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 汉诺塔();
		
	}
	public 汉诺塔(){
		stack0=new myStack<String>("4,3,2,1");
		stack1=new myStack<String>("");
		stack2=new myStack<String>("");
		
		stackarr=new myStack[3]; //泛型数组
		stackarr[0]=stack0;
		stackarr[1]=stack1;
		stackarr[2]=stack2;
		
		execute(stack0.size(),0,2);
		stack0.printStack();
		stack1.printStack();
		stack2.printStack();
	}
	
	public void execute(int n, int a,int b){
		if(n==1){
			System.out.println("\n"+a+" to "+b);
			stackarr[b].mypush(stackarr[a].mypop());
			return;
		}
		execute(n-1,a,3-a-b);
		execute(1,a,b);
		execute(n-1,3-a-b,b);
		
	}
}
