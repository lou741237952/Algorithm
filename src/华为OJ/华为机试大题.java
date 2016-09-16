package 华为OJ;
/**
 * 一组数按从小到大输出，连续部分只输出首尾
 */
import java.util.Arrays;

public class 华为机试大题 {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 5, 8, 6, 7, 11, 13, 12, 20, 21, 22, 30 };
		Arrays.sort(arr);
		boolean tag = false;
		int temp = arr[0];
		System.out.print(arr[0] + " ");
		for (int i = 1; i <= arr.length - 1; i++) {
			if (arr[i] - 1 == temp) {
				tag = true;
			} else {
				if (tag == false) {
					System.out.print(arr[i]);
				} else {
					System.out.print(temp + " " + arr[i]);
					tag = false;
				}
				System.out.print(" ");
			}
			if (i == arr.length - 1 && tag == true) {
				System.out.print(arr[i]);
			}

			temp = arr[i];
		}
	}
}
