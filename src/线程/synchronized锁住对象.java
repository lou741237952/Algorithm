package 线程;

public class synchronized锁住对象 {

	public static void main(String[] args) {
		synchronized锁住对象 main = new synchronized锁住对象();
		Thread a = new Thread(main.new mythread1(main));
		Thread b = new Thread(main.new mythread2(main));
		a.start();
		b.start();
	}

	public synchronized void meth1() {// synchronized锁住了对象 相当于synchronized(this)
		for (int i = 0; i <= 5; i++) {
			System.out.println(1);
		}
	}

	public synchronized void meth2() {
		for (int i = 0; i <= 5; i++) {
			System.out.println(2);
		}
	}

	class mythread1 implements Runnable {
		synchronized锁住对象 main;

		public mythread1(synchronized锁住对象 main) {
			this.main = main;
		}

		@Override
		public void run() {
			main.meth1();
		}

	}

	class mythread2 implements Runnable {
		synchronized锁住对象 main;

		public mythread2(synchronized锁住对象 main) {
			this.main = main;
		}

		@Override
		public void run() {
			main.meth2();
		}

	}
}
