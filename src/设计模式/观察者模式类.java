package 设计模式;

import java.util.Observable;
import java.util.Observer;

public class 观察者模式类 {

	public static void main(String[] args) {
		物体 object = new 物体();
		观察者1 observer1 = new 观察者1();
		观察者2 observer2 = new 观察者2();
		object.addObserver(observer1);
		object.addObserver(observer2);
		System.out.println(object.hasChanged());
		object.setChanged();// 必须先setChange后才能notify，不然无效,每次notify前都需要set
		System.out.println(object.hasChanged());
		object.notifyObservers();
//		object.notifyObservers("带参数"); //带的参数可以再update中获得
		System.out.println(object.countObservers());
	}
}

class 物体 extends Observable {

	@Override
	public void notifyObservers() {
		super.notifyObservers();
	}

	@Override
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		super.deleteObserver(o);
	}

	@Override
	public synchronized void deleteObservers() {
		super.deleteObservers();
	}

	@Override
	protected synchronized void setChanged() {
		super.setChanged();
	}

	@Override
	protected synchronized void clearChanged() {
		super.clearChanged();
	}

	@Override
	public synchronized boolean hasChanged() {
		return super.hasChanged();
	}

	@Override
	public synchronized int countObservers() {
		return super.countObservers();
	}
}

class 观察者1 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察者1--收到通知");
	}
}

class 观察者2 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("观察者2--收到通知");
	}
}