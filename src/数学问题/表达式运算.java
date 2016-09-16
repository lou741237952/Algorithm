package 数学问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 表达式运算 {
	public static void main(String[] args) {
		// 3+2*{1+2*[-4/(8-6)+7]}
		// 1+2*3+(4*5+6)*7
		// 123*+45*6+7*+
		String s = new Scanner(System.in).nextLine();
		String[] test = changeString(s);
		
		 test = In2PostFix(test);
		 System.out.println("--------------------------");
		 System.out.println("逆波兰表达式:");
		 for(String n:test){
			 System.out.print(n);
		 }
		 System.out.println("\n--------------------------");
		 String result = calculate(test);
		 System.out.println(result);
		
	}

	private static String[] In2PostFix(String[] arr) {
		// 中缀表达式变成后缀表达式
		/**
		 * 前缀表达式
		 * 从最右侧开始扫描
		 * 数字 直接输出
		 * ")"直接push
		 * "(" print(pop())知道遇到右括号")",在pop(")")
		 * 运算符,一直print(pop()),直到栈顶元素小于此运算符，push()  优先级 乘除为2 加减为1 其他为0
		 */
		/**
		 * 数字 直接输出 
		 * "(" 直接push 
		 * ")" 输出print(pop())直到"(",然后pop("(")
		 * "operator"一直print(pop())到peek()的优先级小于要放入的操作符 优先级 乘除为2 加减为1 其他为0
		 */
		ArrayList<String> temp = new ArrayList<String>();
		LinkedList<String> stack = new LinkedList<String>();
		for (String s : arr) {
			if (s.matches("^\\-?\\d+$")) {
				//数字情况
				temp.add(s);
			} else if ("(".equals(s) || "[".equals(s) || "{".equals(s)) {
				//左括号
				stack.addFirst(s);
			} else if ("+".equals(s) || "-".equals(s) || "*".equals(s)
					|| "/".equals(s)) {
				//操作符
				int prio = priority(s);
				while (!stack.isEmpty() && priority(stack.peek()) >= prio) {
					temp.add(stack.poll());
				}
				stack.addFirst(s);
			} else if (")".equals(s)) {
				while (!stack.isEmpty() && !"(".equals(stack.peek())) {
					temp.add(stack.poll());
				}
				if (stack.isEmpty()) {
					return new String[]{"Wrong Expression"};
				} else {
					stack.poll();
				}
			} else if ("}".equals(s)) {
				while (!stack.isEmpty() && !"{".equals(stack.peek())) {
					temp.add(stack.poll());
				}
				if (stack.isEmpty()) {
					return new String[]{"Wrong Expression"};
				} else {
					stack.poll();
				}
			} else if ("]".equals(s)) {
				while (!stack.isEmpty() && !"[".equals(stack.peek())) {
					temp.add(stack.poll());
				}
				if (stack.isEmpty()) {
					return new String[]{"Wrong Expression"};
				} else {
					stack.poll();
				}
			} else {
				return new String[]{"Wrong Expression"};
			}
		}
		while (!stack.isEmpty()) {
			temp.add(stack.poll());
		}
		return temp.toArray(new String[temp.size()]);
	}

	private static String calculate(String[] str) {
		/**
		 * 计算后缀表达式 如果是数字直接push 如果是operator把最上面的两个数字pop出来处理 循环直到处理完
		 */
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i <= str.length - 1; i++) {
			if (str[i].matches("^\\-?\\d+$")) {
				list.addFirst(str[i]);
			} else {
				int a = Integer.valueOf(list.poll());
				int b = Integer.valueOf(list.poll());
				if ("+".equals(str[i])) {
					list.addFirst(String.valueOf(b + a));
				} else if ("-".equals(str[i])) {
					list.addFirst(String.valueOf(b - a));
				} else if ("*".equals(str[i])) {
					list.addFirst(String.valueOf(b * a));
				} else if ("/".equals(str[i])) {
					list.addFirst(String.valueOf(b / a));
				}
			}
		}
		return list.poll();
	}

	private static String[] changeString(String str) {
		// 处理字符串把大于10的数当成一个数放入String数组中
		ArrayList<String> temp = new ArrayList<String>();
		String[] init = str.split("");
		for (int i = 0; i <= init.length - 1;) {
			if (init[i].matches("^\\d$")) {
				StringBuilder sb = new StringBuilder();
				while (i <= init.length - 1 && init[i].matches("^\\d$")) {
					sb.append(init[i]);
					i++;
				}
				temp.add(sb.toString());
			} else {
				// 负号情况单独处理
				if ("-".equals(init[i])) {
					// 前面是加括号前括号通过加0处理
					if (i == 0 || init[i-1].matches("[\\{\\[\\(\\+\\-\\*]")) {
						temp.add("-1");
						temp.add("*");
					} 
					else if (init[i - 1].matches("[\\d\\}\\)\\]]")) {
						temp.add(init[i]);
					} 
					else {
						// 除号情况
						temp.add("-1");
						temp.add("/");
					}
				} else {
					// 不是负号情况
					temp.add(init[i]);
				}
				i++;
			}
		}
		return temp.toArray(new String[temp.size()]);
	}

	private static int priority(String c) {
		if ("*".equals(c) || "/".equals(c))
			return 2;
		if ("+".equals(c) || "-".equals(c))
			return 1;
		else
			return 0;
	}
}
