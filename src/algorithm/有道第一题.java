package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

//3
//3 1
//1 2 3 4 5 6
//3 2
//1 2 3 4 5 6
//2 2
//1 1 1 1
public class 有道第一题 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();// 数据个数
		for (int i = 1; i <= n; i++) {
			int a = scan.nextInt();// 排数
			int b = scan.nextInt();// 洗牌次数
			Integer[] arr = new Integer[2 * a];
			for (int m = 0; m <= 2 * a - 1; m++) {
				arr[m] = scan.nextInt();
			}
			for (int o = 1; o <= b; o++) {
				arr = solve(arr);
			}
			for (int in = 0; in <= arr.length - 1; in++) {
				System.out.print(arr[in]);
				if (in != arr.length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static Integer[] solve(Integer[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = arr.length;
		for (int i = 0; i <= num / 2 - 1; i++) {
			list.add(arr[i]);
			list.add(arr[i + num / 2]);
		}
		return list.toArray(new Integer[list.size()]);
	}
}
