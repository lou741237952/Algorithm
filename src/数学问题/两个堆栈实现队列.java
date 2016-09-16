package 数学问题;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class 两个堆栈实现队列 {

	public static void main(String[] args) {
		stackQueue<Integer> mystack = new stackQueue<Integer>();
		mystack.enqueue(1);
		mystack.enqueue(2);
		mystack.enqueue(3);
		System.out.println(mystack);
		mystack.dequeue();
		System.out.println(mystack);
		mystack.enqueue(4);
		System.out.println(mystack);
		while (!mystack.isEmpty()) {
			mystack.dequeue();
			System.out.println(mystack);
		}
	}

}

// push时候放入第一个堆,pop时候如果第二个堆不为空则第二个堆pop，否则第一个堆的全部pop再push到第二个堆，第二个堆pop
class stackQueue<T> {
	private LinkedList<T> listPush = new LinkedList<T>();
	private LinkedList<T> listPop = new LinkedList<T>();

	void enqueue(T t) {
		listPush.addFirst(t);
	}

	T dequeue() {
		if (listPop.isEmpty()) {
			while (!listPush.isEmpty()) {
				listPop.push(listPush.poll());
			}
		}
		return listPop.poll();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<T> iter = listPush.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next().toString());
			if (iter.hasNext()) {
				sb.append(",");
			}
		}
		if (!listPop.isEmpty()) {
			if (!listPush.isEmpty()) {
				sb.append(",");
			}
			ListIterator<T> it = listPop.listIterator(listPop.size());
			while (it.hasPrevious()) {
				sb.append(it.previous().toString());
				if (it.hasPrevious()) {
					sb.append(",");
				}
			}
		}
		return String.format("[%s]", sb.reverse().toString());
	}

	boolean isEmpty() {
		return listPush.isEmpty() && listPop.isEmpty();
	}
}