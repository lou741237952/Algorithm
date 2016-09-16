package 查找;

import java.util.Arrays;

public class 二分查找 {
	// 0 1 2 3 4 5 6 7 8
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int target = 1;
		Arrays.sort(arr);

		int index = nonRecursive(arr, target);
		System.out.println(index);
		int inDex = doRecursive(arr, 0, arr.length - 1, target);
		System.out.println(inDex);
	}

	// 二分查找前提是排好序了
	static int nonRecursive(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (true) {
			mid = (start + end) / 2;
			if (start > end) {
				return -1;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
	}

	static int doRecursive(int[] arr, int start, int end, int target) {
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		} else if (target > arr[mid]) {
			return doRecursive(arr, mid + 1, end, target);
		} else if (target < arr[mid]) {
			return doRecursive(arr, start, mid - 1, target);
		} else {
			return mid;
		}
	}
}
