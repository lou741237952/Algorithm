package 华为OJ;

import java.util.ArrayList;
import java.util.Scanner;

public class 购物单 {
	static int LIMIT;
	static int VALUE;
	static Integer[] DATA;
	static Integer[] PRICE;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LIMIT = scan.nextInt();
		int num = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> price = new ArrayList<Integer>();
		for (int i = 1; i <= num; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			if (c > 0) {
				list.set(c - 1, list.get(c - 1) + a * b);
				price.set(c - 1, price.get(c - 1) + a);
			}
			if (c == 0) {
				list.add(a * b);
				price.add(a);
			}
		}
		DATA = list.toArray(new Integer[list.size()]);
		PRICE = price.toArray(new Integer[list.size()]);
		count(0, LIMIT, 0);
		System.out.println(VALUE);
	}

	// 1000 5 800 2 0 400 5 1 300 5 1 400 3 0 500 2 0
	// 零一背包问题
	static void count(int index, int valueLeft, int tempSum) {
		// 先判断边界
		if (index == DATA.length) {
			VALUE = (valueLeft < 0) ? VALUE : Math.max(tempSum, VALUE);
			return;
		}
		// 再判断介质条件
		if (valueLeft <= 0) {
			if (valueLeft == 0) {
				VALUE = Math.max(tempSum, VALUE);
			} else {
				VALUE = Math.max(tempSum - DATA[index - 1], VALUE);
			}
			return;
		}
		// 0或者1
		count(index + 1, valueLeft - PRICE[index], tempSum + DATA[index]);
		count(index + 1, valueLeft, tempSum);
	}
}
