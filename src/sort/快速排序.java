package sort;

/**
 * quicksort demo
 * 
 * @author lou
 *
 */
public class 快速排序 {
	private char[] arr;
	private char temp;

	public static void main(String[] args) {
		long start = System.nanoTime();
		String input = "qazwsxedcrfvtgbyhnujmiklop0987654321";
		System.out.println(input);
		new 快速排序(input);
		long stop = System.nanoTime();
		System.out.println("Time:" + (double) (stop - start) / 1000000 + "ms");
	}

	public 快速排序(String str) {
		this.arr = str.toCharArray();
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}

	public void quickSort(char[] arr, int start, int end) {
		int middle = (start + end) / 2;
		getMedian(arr, start, middle, end);
		if (end - start > 2) {
			int pivot = end - 1;
			swap(arr, middle, pivot);
			int i = start + 1, j = pivot - 1;
			while (true) {
				while (arr[i] < arr[pivot]) {
					i++;
				} // 最多走到pivot
				while (arr[j] > arr[pivot]) {
					j--;
				} // 最多走到第一个数
				if (i < j) {
					swap(arr, i, j);
				} else {
					break;
				}
			}
			swap(arr, i, pivot);
			quickSort(arr, start, i - 1); // pivot位置定好了不用加入下一步排序中了
			quickSort(arr, i + 1, end);
		}
	}

	public void printArr(char[] arr) {
		System.out.println("GET!: " + String.valueOf(arr));
	}

	public void getMedian(char[] arr, int left, int middle, int right) {
		if (arr[right] < arr[left]) {
			swap(arr, left, right);
		}
		if (arr[right] < arr[middle]) {
			swap(arr, middle, right);
		}
		if (arr[middle] < arr[left]) {
			swap(arr, left, middle);
		}
	}

	public void swap(char[] arr, int a, int b) {
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
