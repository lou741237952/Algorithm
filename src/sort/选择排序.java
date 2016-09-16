package sort;

/**
 * 选择排序
 * 
 * @author lou
 *
 */
public class 选择排序 {

	public static void main(String[] args) {
		String input = "zaqxswcdevfrbgtnhymjukilop9876543210";
		System.out.println(input);
		long start = System.nanoTime();
		new 选择排序(input);
		long stop = System.nanoTime();
		System.out.println("Time:" + (double) (stop - start) / 1000000 + "ms");

	}

	public 选择排序(String str) {
		char[] arr = str.toCharArray();
		char temp;
		// 从前往后遍历位置，将后面每个比这个数大的数与这个数交换
		for (int i = 0; i <= arr.length - 1; i++) {
			for (int n = i + 1; n <= arr.length - 1; n++) {
				if (arr[i] > arr[n]) {
					temp = arr[n];
					arr[n] = arr[i];
					arr[i] = temp;
				}
			}
		}

		System.out.println("GET!: " + new String(arr));

	}
}
