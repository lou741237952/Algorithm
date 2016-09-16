package sort;

public class 堆排序 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		String str = "qazwsxedcrfvtgbyhnujmiklop9876543210";
		HeapSort(str);
		long stop = System.nanoTime();
		System.out.println("\nTime: " + (double) (stop - start) / 1000000
				+ "ms");
	}

	static void HeapSort(String str) {
		char[] arr = new char[str.length() + 1];
		for (int i = 0; i <= str.length() - 1; i++) {
			// 建堆，序号从1开始
			arr[i + 1] = str.charAt(i);
		}
		for (int i = (arr.length - 1) / 2; i >= 1; i--) {
			// 从倒数第二行最后一个数开始下滤
			percDown(arr, i);
		}
		for (int i = 1; i <= arr.length - 1; i++) {
			delMin(arr);
		}
	}

	static void percDown(char[] arr, int n) {
		int left = 2 * n;
		int right = 2 * n + 1;
		int min = n;
		// 得到三个节点中最小的数的序号min
		if (left <= arr.length - 1 && arr[left] < arr[n]) {
			min = left;
		}
		if (right <= arr.length - 1 && arr[right] < arr[min]) {
			min = right;
		}
		// 如果调整了，顺着调整的元素继续下滤
		if (min != n) {
			swap(arr, n, min);
			percDown(arr, min);
		}
	}

	static void delMin(char[] arr) {
		System.out.print(arr[1]);
		arr[1] = (char) Integer.MAX_VALUE;
		percDown(arr, 1);
	}

	static void swap(char[] arr, int i, int m) {
		char temp = arr[i];
		arr[i] = arr[m];
		arr[m] = temp;
	}
}
