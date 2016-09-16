package algorithm;

public class 父类执行子类方法 {

	public static void main(String[] args) {
		父类执行子类方法 father = new 子类();
		// System.out.println(father.a);
		// father.setParameter(10);
		father.method();
		father.method1();
		// father.method2(); //父类没有的方法，父类引用不能使用
		// 父类接口 fa=new 子类();
		// fa.method2(); //接口也是一样，没有定义过得方法调用不了
	}

	private int a = 5;

	public void method() {
		System.out.println("父类方法");
	}

	void method1() {
		System.out.println("被子类继承的方法");
	}

	void setParameter(int a) {
		System.out.println(this.a);
		this.a = a;
		System.out.println(this.a);
	}

}

interface 父类接口 {

	abstract void method();
}

class 子类 extends 父类执行子类方法 implements 父类接口 {
	int a = 4;

	public void method() {
		System.out.println("子类方法");
		System.out.println(a);
	}

	void method2() {
		System.out.println("父类没有的方法，父类引用不能使用");
	}
}
