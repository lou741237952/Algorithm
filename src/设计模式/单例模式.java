package 设计模式;

public class 单例模式 {
	public static void main(String[] args) {
		饿汉单例模式 hungry = 饿汉单例模式.getInstance();
		懒汉单例模式 lazy = 懒汉单例模式.getInstance();
	}
}

// 由于构造函数用了private 所以不能创建对象 只能通过方法得到，每次得到的都是同一个对象
class 饿汉单例模式 {
	private static 饿汉单例模式 hungryMode = new 饿汉单例模式();

	private 饿汉单例模式() {
		System.out.println("饿汉单例模式创建");
	}

	static 饿汉单例模式 getInstance() {
		return hungryMode;
	}

}

class 懒汉单例模式 {
	private static 懒汉单例模式 lazyMode;

	private 懒汉单例模式() {
		System.out.println("懒汉单例模式创建");
	}

	synchronized static 懒汉单例模式 getInstance() {
		if (lazyMode == null) {
			lazyMode = new 懒汉单例模式();
		}
		return lazyMode;
	}
}
