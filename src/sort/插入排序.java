package sort;

/**
 * 插入排序
 * 
 * @author lou
 *
 */
public class 插入排序 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		// String input="zaqxswcdevfrbgtnhymjukiolp9876543210";
		String input = "type";
		System.out.println(input);
		new 插入排序(input);
		long stop = System.nanoTime();
		System.out.println("Time: " + (double) (stop - start) / 1000000 + "ms");
	}

	public 插入排序(String str) {
		char[] arr = str.toCharArray();
		int length = arr.length - 1;

		for (int i = 0; i <= length; i++) {
			char temp = arr[i]; // 与冒泡排序不同的地方
			int n = i;
			while (n >= 1 && temp < arr[n - 1]) {
				arr[n] = arr[n - 1]; // 要排序的元素先保存起来，把每个元素向后赋值而不是与后面交换
				n--;
			}
			arr[n] = temp;
		}

		System.out.println("GET!: " + new String(arr));
	}
}
