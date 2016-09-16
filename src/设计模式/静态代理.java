package 设计模式;

public class 静态代理 {

	public static void main(String[] args) {
		// 客户操作
		静态代理接口 proxy=代理工厂.创建对象();
		proxy.dealTask("客户业务");
	}

}

/**
 * 实体类和代理类都实现了代理接口 
 *  代理工厂为客户返回代理实例，客户并不知道返回的是原实体类还是代理类
 * @author lou
 *
 */
interface 静态代理接口 {
	public void dealTask(String taskName);
}

class 静态代理实体类 implements 静态代理接口 {

	@Override
	public void dealTask(String taskName) {
		System.out.println("实体类中的核心方法:" + taskName);
	}
}

class 代理类 implements 静态代理接口 {
	private 静态代理实体类 realObject;

	代理类(静态代理实体类 realObject) {
		this.realObject = realObject;
	}

	@Override
	public void dealTask(String taskName) {
		System.out.println("前置通知");
		realObject.dealTask(taskName);
		System.out.println("后置通知");
	}

}

class 代理工厂 {
	public static 静态代理接口 创建对象() {
		return new 代理类(new 静态代理实体类());
	}
}