package 数学问题;

import java.util.LinkedList;

public class M个数分成N组 {
	static int NUM;
	static int divNUM;
	static Integer[] temp;
	static LinkedList<Integer[]> result = new LinkedList<Integer[]>();

	public static void main(String[] args) {
		NUM = 5;// 总个数
		divNUM = 2;// 分的组数
		temp = new Integer[divNUM];// 中间数据
		div(NUM, divNUM);
	}

	static void core() {
		// 最终数据处理逻辑
		for (Integer i : temp) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static void div(int num, int div) {
		// num个数分为div组
		if (div == 1) {
			// 如果只分一组停止，剩下的数分为一组
			temp[divNUM - div] = num;
			core();
			return;
		}
		for (int i = 1; i <= num - (div - 1); i++) {
			// 前i个数分为一组，剩下的就是num-i个数分为div-1组
			temp[divNUM - div] = i;
			div(num - i, div - 1);
		}
	}
}
