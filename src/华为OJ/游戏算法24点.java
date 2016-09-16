package 华为OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 游戏算法24点 {
	static final Double TFP = 24 + 0.2;
	static final Double TFN = 24 - 0.2;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Double n1 = scan.nextDouble();
		Double n2 = scan.nextDouble();
		Double n3 = scan.nextDouble();
		Double n4 = scan.nextDouble();
		游戏算法24点 a = new 游戏算法24点();
		Double[] a1 = a.allOperate(n1, n2); // 任意选两个数有六种，每种6种运算方式返回数组保存
		Double[] a2 = a.allOperate(n1, n3);
		Double[] a3 = a.allOperate(n1, n4);
		Double[] a4 = a.allOperate(n2, n3);
		Double[] a5 = a.allOperate(n2, n4);
		Double[] a6 = a.allOperate(n3, n4);
		a.arrpermutate(a1, a2, a3, a4, a5, a6); // 每两个一组有六组，组组之间运算
	}

	Double[] allOperate(Double a, Double b) {// 得到两个数的六种结果
		Double[] result = new Double[6];
		result[0] = a + b;
		result[1] = a - b;
		result[2] = b - a;
		result[3] = a * b;
		result[4] = a / b;
		result[5] = b / a;
		return result;

	}

	boolean judge(Double[] a, Double[] b) { // 判断两个数组有无24
		for (Double n : a) {
			for (Double m : b) {
				if (subjudge(m + n))
					return true;
				if (subjudge(m - n))
					return true;
				if (subjudge(n - m))
					return true;
				if (subjudge(m * n))
					return true;
				if (subjudge(m / n))
					return true;
				if (subjudge(n / m))
					return true;
			}
		}
		return false;
	}

	boolean arrpermutate(Double[] a, Double[] b, Double[] c, Double[] d,
			Double[] e, Double[] f) {
		List<Double[]> l1 = new ArrayList<Double[]>(Arrays.asList(a, b, c, d,
				e, f));
		List<Double[]> l2 = new ArrayList<Double[]>(Arrays.asList(a, b, c, d,
				e, f));
		for (Double[] first : l1) {
			for (Double[] second : l2) {
				if (first == second) {
					continue;
				}
				if (judge(first, second)) {
					System.out.println(true);
					return true;
				}
				;
			}
		}
		System.out.println(false);
		return false;
	}

	boolean subjudge(Double a) { // 判断是否等于24
		if (a <= TFP && a >= TFN) {
			return true;
		}
		return false;
	}

}
