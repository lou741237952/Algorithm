package algorithm;
class 执行顺序 {
	static int a=1;
	static{System.out.println("父类静态块");}
	int b=2;
	{System.out.println("父类块");}
	执行顺序(){
		System.out.println("父类构造函数");
	}
	void print(){
		System.out.println("父类方法");
	}
}

public class 执行顺序子类 extends 执行顺序{
	static int aa=3;
	static{System.out.println("子类静态块");}
	int b=4;
	{System.out.println("子类块");}
	 public static void main(String[] args){
		 System.out.println("子类main函数");
		 执行顺序 father= new 执行顺序子类();
		 father.print();
		 System.out.println(father.b);
	 }
	 执行顺序子类(){
		 super();
		 System.out.println("子类构造函数");
	 }
//	 void print(){
//			System.out.println("子类方法");
//		}
}