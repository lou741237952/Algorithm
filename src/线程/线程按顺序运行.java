package 线程;

public class 线程按顺序运行 {

	public static void main(String[] args) {
		threadone run = new threadone();
		threaden one = new threaden(run, 1);
		threaden two = new threaden(run, 2);
		threaden thr = new threaden(run, 3);
		one.start();
		two.start();
		thr.start();
	}
}

class threaden extends Thread {
	int index;

	threaden(threadone r, int index) {
		super(r);
		this.index = index;
	}
}

class threadone implements Runnable {
	// runnable只有一个传入多个线程中 所以可以在内部计数，创建锁，判断线程等
	public static int count = 0;
	public int index = 1;
	public static Object lock = new Object();// 锁，对所有线程只有一个

	/**
	 * 基本思想:不对线程顺序进行控制，所有线程每次都竞争同一把锁
	 * 如果一个线程不符合要求，则进入wait状态，知道符合要求的线程进入执行方法，然后notifyAll所有线程 所有线程被唤醒后，在继续竞争
	 */
	@Override
	public void run() {
		synchronized (lock) {
			while (count != 6) { // 循环控制在使用的方法中，而不是循环启动线程
				threaden t = (threaden) Thread.currentThread();
				if (t.index == index) {// 通过线程的名字进行调度
					// 如果线程符合要求执行，然后notifyAll将所有阻塞线程唤醒
					if (index == 3) {
						index = 1;
					} else {
						index++;
					}
					count++;
					System.out.println(t.index);
					lock.notifyAll();// 唤醒线程
				} else {
					// 如果不符合要求，则线程阻塞
					try {
						lock.wait();// 阻塞后回复也是从wait()后面开始，所以run方法需要循环运行
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
