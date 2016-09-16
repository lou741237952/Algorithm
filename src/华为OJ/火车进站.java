package 华为OJ;

import java.util.Scanner;

public class 火车进站 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		arr = new int[n];
		for (int i = 0; i <= n - 1; i++) {
			arr[i] = scan.nextInt();
		}
		new 火车进站().permute(0, n);
	}

	void permute(int start, int n) { // 首先进行全排列
		if (n == 1) {
			if (check(arr)) {
				for (int i = 0; i <= arr.length - 1; i++) {
					System.out.print(arr[i]);
					if (i != arr.length - 1) {
						System.out.print(" ");
					} else {
						System.out.println();
					}

				}

			}
		} else {
			for (int i = start; i <= arr.length - 1; i++) {
				swap(arr, start, i);
				permute(start + 1, n - 1);
				swap(arr, start, i);
			}
		}
	}

	void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	boolean check(int[] arr) { // 每个数字后面的数比他小的必须是降序，满足堆栈性质
		for (int i = 0; i <= arr.length - 1; i++) {
			int temp = arr[i];
			for (int n = i + 1; n <= arr.length - 1; n++) {
				if (arr[n] < arr[i]) {
					if (arr[n] < temp) {
						temp = arr[n];
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}
