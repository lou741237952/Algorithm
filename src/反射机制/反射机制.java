package 反射机制;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class 反射机制 {

	public static void main(String[] args) {
		reflectionDemo re = null;
		System.out.println("--------------类加载开始-----------------");
		// try {
		// Class cls = Class.forName("反射机制.reflectionDemo"); // 会执行静态块不执行构造块
		// re = (reflectionDemo) cls.newInstance(); // 执行构造块和构造函数
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// }
		try {
			ClassLoader cLoader = reflectionDemo.class.getClassLoader();
			// ClassLoader cLoader =
			// Thread.currentThread().getContextClassLoader();
			Class cls = cLoader.loadClass("反射机制.reflectionDemo");// 不会执行静态块不执行构造块，直到第一次使用时才执行
			re = (reflectionDemo) cls.newInstance();// 先执行静态块再执行构造块和构造函数
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------类加载完毕-----------------\n");
		// getDeclared***()指用户写的
		// get***()指系统本身的

		// 方法
		System.out.println("--------------方法-----------------");
		Method[] methods = re.getClass().getDeclaredMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
		System.out.println("--------------构造方法-----------------");
		// 构造方法
		Constructor[] constructors = re.getClass().getDeclaredConstructors();
		for (Constructor c : constructors) {
			System.out.println(c.getName());
		}
		// 成员变量
		System.out.println("--------------成员变量-----------------");
		Field[] fields = re.getClass().getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName());
		}
		System.out.println("--------------方法调用-----------------");
		// 调用方法
		try {
			methods[0].setAccessible(true);// 私有方法必须忽略属性检查才能访问
			methods[0].invoke(re);
			methods[1].invoke(re, 999);

			System.out.println("----------变量获取---------------------");
			fields[0].setAccessible(true);// 私有变量必须忽略属性检查才能访问
			System.out.printf("%s\n%s\n", (String) fields[0].get(re),
					(String) fields[1].get(re));

			System.out.println("----------修改变量---------------------");
			fields[0].set(re, "modified-privateParam");// 私有变量必须忽略属性检查才能修改
			fields[1].set(re, "modified-publicParam");
			System.out.printf("%s\n%s", (String) fields[0].get(re),
					(String) fields[1].get(re));

		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

class reflectionDemo {
	private String privateParam = "privateParam";
	String publicParam = "publicParam";

	static {
		System.out.println("静态块");
	}
	{
		System.out.println("构造块");
	}

	reflectionDemo() {
		System.out.println("构造方法\n");
	}

	private void method1() {
		System.out.println("private method1");
	}

	void method2(int i) {
		System.out.println("method2: parameter-" + i);
	}
}
