package 线程;

public class 线程本地储存 {
	// threadlocal线程共享，但是对于每个线程取得的东西是不同的,相当于封装了某个类中的成员变量,当成正常的成员变量使用
	ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	String name = "默认值";// 线程共享，会出现同步问题

	public static void main(String[] args) {
		线程本地储存 test = new 线程本地储存();
		int n = 10;
		自制线程[] thread = new 自制线程[n];
		for (int i = 0; i <= n - 1; i++) {
			thread[i] = new 自制线程("线程" + i, test);
		}
		for (int i = 0; i <= n - 1; i++) {
			thread[i].start();
		}

	}

	// threalocal第二种用法,封装某个类，提供set和get方法，使得这个类中的数据是线程独有的
	// static class SerialNum<T> {
	// private ThreadLocal<T> threadLocal;
	//
	// void set(T t) {
	// if (this.threadLocal == null) {
	// threadLocal = new ThreadLocal<T>();
	// }
	// threadLocal.set(t);
	// }
	//
	// T get() {
	// if (this.threadLocal == null) {
	// return null;
	// }
	// return threadLocal.get();
	// }
	// }
}

class 自制线程 extends Thread {
	线程本地储存 test;
	String name;

	自制线程(String name, 线程本地储存 test) {
		super(name);
		this.test = test;
		this.name = name;
	}

	@Override
	public void run() {
		test.threadLocal.set(name);// 放入threadlocal,线程独有
		test.name = name;// 放入非同步的成员变量中，会出现同步问题,其值为最后一次使用类的线程所设置
		System.out.println(Thread.currentThread().getName()
				+ "设置了ThreadLocal和成员变量");
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()
				+ "-ThreadLocal内容为:" + test.threadLocal.get() + " 成员变量内容为"
				+ test.name);
	}

}