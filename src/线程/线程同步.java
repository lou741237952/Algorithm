/**
 * 10个物品，一个人取速度为1另一个人为2，两人竞赛。
 */
package 线程;

public class 线程同步 {

	public static void main(String[] args) {
		participant p = new participant("race"); // 一个实例participant被多个线程使用
		Mythread thread1 = new Mythread(p, "Person A", 1);
		Mythread thread2 = new Mythread(p, "Person B", 1);
		thread1.start();
		thread2.start();
	}

}

class Mythread extends Thread {
	private participant p;
	int step;

	public Mythread(participant p, String str, int step) {
		super(str);

		this.step = step;
		this.p = p;
	}

	public void run() {
		p.race(step);
	}

}

class participant {
	Object lock = new Object();
	String name;
	int sum = 0; // 两个人走的总路程

	public participant(String name) {
		this.name = name;
	}

	public void race(int step) {
		while (sum <= 10) {
			synchronized (lock) {
				sum += step;
				try {
					System.out.println(Thread.currentThread().getName()
							+ " advanced now: " + sum);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
