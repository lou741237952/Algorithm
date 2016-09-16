package 字符串;

import java.util.ArrayList;

public class 提取数字每位数 {
	public static void main(String[] args) {
		Integer[] a = everyNum(0);
		for (Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\n位数:" + a.length);
		System.out.println(toInteger(a));
	}

	// 返回一个Integer数组，序号从小到大对应n从大到小每位的数字
	static Integer[] everyNum(int n) {
		if (n == 0) {
			return new Integer[] { 0 };
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int reminder = n;
		while (reminder != 0) {
			temp.add(0, reminder % 10);
			reminder /= 10;
		}
		return temp.toArray(new Integer[temp.size()]);
	}

	// Integer数组变成int
	static int toInteger(Integer[] arr) {
		int result = 0;
		for (int i = 0; i <= arr.length - 1; i++) {
			result += (arr[i] * Math.pow(10, i));
		}
		return result;
	}
}
