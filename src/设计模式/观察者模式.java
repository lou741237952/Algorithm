package 设计模式;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class 观察者模式 {

	public static void main(String[] args) {
		观察者接口 obs1 = new 具体观察者1();
		观察者接口 obs2 = new 具体观察者2();
		物体接口 obj = new 具体物体();
		obj.attach(obs1);
		obj.attach(obs2);
		obj.notifyObserver();
	}
}

interface 物体接口 {
	void attach(观察者接口 observer);

	void detach(观察者接口 observer);

	void notifyObserver();
}

interface 观察者接口 {
	void update();
}

class 具体物体 implements 物体接口 {
	private Vector<观察者接口> obsVector = new Vector<观察者接口>(); // arraylist的线程同步版本

	@Override
	public void attach(观察者接口 observer) {
		obsVector.add(observer);
	}

	@Override
	public void detach(观察者接口 observer) {
		obsVector.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for (观察者接口 obs : obsVector) {
			obs.update(); // 调用观察者自身的改变方式，可以做到对不同观察者不同的update
		}
	}
}

class 具体观察者1 implements 观察者接口 {

	@Override
	public void update() {
		System.out.println("具体观察者1--收到物体的通知!");
	}
}

class 具体观察者2 implements 观察者接口 {

	@Override
	public void update() {
		System.out.println("具体观察者2--收到物体的通知!");
	}
}


