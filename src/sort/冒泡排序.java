package sort;

/**
 * 冒泡排序
 * 
 * @author lou
 *
 */
public class 冒泡排序 {

	public static void main(String[] args) {
		String input = "zaqxswcdevfrbgtnhymjukilop9876543210";
		System.out.println(input);
		long start = System.nanoTime();
		new 冒泡排序(input);
		long stop = System.nanoTime();
		System.err.println("Time: " + (double) (stop - start) / 1000000 + "ms");
	}

	// 从最后一个数开始遍历，把序号小于这个位置的数中最大的那个移到这个位置
	public 冒泡排序(String str) {
		char[] arr = str.toCharArray();
		char temp;
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int n = 0; n <= i - 1; n++) {
				if (arr[n] > arr[n + 1]) {
					temp = arr[n];
					arr[n] = arr[n + 1];
					arr[n + 1] = temp;
				}
			}
		}
		System.out.println("GET!: " + new String(arr));
	}
}
