package sort;

/**
 * 归并排序
 * 
 * @author lou
 *
 */
public class 归并排序 {
	private char[] result;
	private char[] temp; // 临时数组用于保存数据

	public static void main(String[] args) {
		long start = System.nanoTime();
		String input = "qazwsxedcrfvtgbyhnujmiklop0987654321";
		System.out.println(input);
		new 归并排序(input);
		long stop = System.nanoTime();
		System.out.println("Time:" + (double) (stop - start) / 1000000 + "ms");

	}

	public 归并排序(String str) {
		this.result = str.toCharArray();
		this.temp = new char[result.length];
		mergeSort(result, temp, 0, result.length - 1);
		printResult(result);
	}

	public void mergeSort(char[] arr, char[] temp, int left, int right) {
		if (left != right) {
			int middle = (left + right) / 2;
			mergeSort(arr, temp, left, middle);
			mergeSort(arr, temp, middle + 1, right);
			merge(arr, temp, left, middle, right);
		}
	}

	public void merge(char[] arr, char[] temp, int left, int middle, int right) {
		int tempPos = left; // 游标
		int l = left;
		int r = middle + 1;

		while (l <= middle && r <= right) {
			if (arr[l] < arr[r]) { // 左边小，放入temp[]中
				temp[tempPos++] = arr[l++];

			} else if (arr[l] > arr[r]) { // 右边小，放入temp[]中
				temp[tempPos++] = arr[r++];

			} else { // 左右一样大,都放入temp[]中
				temp[tempPos++] = arr[l++];
				temp[tempPos++] = arr[r++];
			}
		}
		// 两边中肯定有一边已经走完
		while (l <= middle) { // 左边剩下放入temp[]中
			temp[tempPos++] = arr[l++];
		}
		while (r <= right) { // 右边剩下放入temp中[]
			temp[tempPos++] = arr[r++];
		}
		for (int i = left; i <= right; i++) { // 保存回原来数组不然再次搜索会乱
			arr[i] = temp[i];
		}

	}

	public void printResult(char[] arr) {
		System.out.println("GET!:" + new String(arr));
	}

}
