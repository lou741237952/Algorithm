package algorithm;

import java.io.UnsupportedEncodingException;

interface aaa{
	 static final int x=0;
	
}
public class 引用换值问题 implements aaa{
	static String str="a";
	public static void main(String[] args)  {
		
		test1 t1=new test1(1);
		test1 t2=new test1(2);
		test1 temp=new test1();
		
//		temp=t1;
//		t1=t2;
//		t2=temp;
		引用换值问题 a=new 引用换值问题();
			System.out.println("原本: "+t1.a+" "+t2.a);
			
				a.test(t1,t2);
				System.out.println(t1.a+" "+t2.a);	//有用
					
//				a.test(t1.a,t2.a);
//				System.out.println(t1.a+" "+t2.a);	//无用	
//				
//				a.test(t1,t2,temp);
//				System.out.println(t1.a+" "+t2.a);	//无用
	}
	
	
	private 引用换值问题(){}
	public  void test(test1 t1,test1 t2){
		int temp;
		temp=t1.a;
		t1.a=t2.a;
		t2.a=temp;
	}
	public void test(int a, int b){
		int temp;
		temp=a;
		b=a;
		a=temp;
	}
	public  void test(test1 t1,test1 t2, test1 temp){
		temp=t1;
		t2=t1;
		t1=temp;
	}
	
}

class test1{
	int a;
	public test1(int b){
		
		this.a=b;
	}
	public test1(){};
}