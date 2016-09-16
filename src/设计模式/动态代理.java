package 设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理 {

	public static void main(String[] args) {
		动态代理接口 proxy = 动态代理工厂.getInstance();
		proxy.dealTask("客户业务");
		System.out.println(proxy.getClass().getSimpleName());
		动态代理接口 proxy2 = 动态代理工厂.getInstance();
		System.out.println(proxy2.getClass().getSimpleName());// 同一个调用处理器，同一组接口，实例只有一个不会重复创建
		System.out.println(proxy == proxy2);
	}
}

interface 动态代理接口 {
	public void dealTask(String taskName);
}

class 动态代理实体类 implements 动态代理接口 {

	@Override
	public void dealTask(String taskName) {
		System.out.println("实体类中的核心方法:" + taskName);
	}
}

class 实体类调用处理器 implements InvocationHandler {

	private Object realObject;

 	实体类调用处理器(Object realObject) {
		this.realObject = realObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("前置通知");
		method.invoke(realObject, args);
		System.out.println("后置通知");
		return null;
	}
}

class 动态代理工厂 {
	public static 动态代理接口 getInstance() {
		动态代理接口 temp = new 动态代理实体类();
		InvocationHandler invocationHandler = new 实体类调用处理器(temp);
		动态代理接口 interf = (动态代理接口) Proxy.newProxyInstance(temp.getClass()
				.getClassLoader(), temp.getClass().getInterfaces(),
				invocationHandler);
		return interf;
	}
}