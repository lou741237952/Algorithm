package DP;

import java.util.LinkedList;

class myStack<T> extends LinkedList<T> {

	public static void main(String[] args) {
		myStack<String> stack = new myStack<String>("1");
		stack.mypop();
		stack.mypush("楼洋");
		stack.mypop();
		stack.mypush(null);
		stack.mypop();
		stack.printStack();
	}

	public myStack() {
		super();
	}

	public myStack(String str) { // 泛型类的构造函数不用加<>

		String[] stackstr = str.split(",");
		for (int i = 0; i <= stackstr.length - 1; i++) {
			mypush((T) stackstr[i]);
		}
		printStack();
	}

	public synchronized void mypush(T t) {
		if (t == null) {
			System.err.println("Could not push null into stack!");
		} else {
			push(t);
			System.out.println("push: " + t.toString());
		}
	}

	public synchronized T mypop() {
		T t;
		if ((t = poll()) != null) {
			System.out.println("pop: " + t.toString());
		} else {
			System.err.println("Pop failed ! Stack is empty!");
		}

		return t;
	}

	public synchronized void printStack() {
		System.out.println(this.getClass().getName() + "" + toString());
	}
}
