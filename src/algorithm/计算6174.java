package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class 计算6174 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String test = in.nextLine();
		char[] arr = test.toCharArray();
		while (check(arr)) {
			Arrays.sort(arr);
			char[] inc = adjust(arr);
			char[] dec = new char[inc.length];
			for (int i = 0; i <= dec.length - 1; i++) {
				dec[i] = inc[inc.length - 1 - i];
			}
			String big = new String(inc);
			String sma = new String(dec);
			int a = Integer.valueOf(big);
			int b = Integer.valueOf(sma);
			int result = b - a;
			if (result <= 999) {
				char[] r = Integer.toString(result).toCharArray();
				arr = adjust(r);
			} else {
				arr = Integer.toString(result).toCharArray();
			}
			System.out.println(b + " - "
					+ new String(adjust(Integer.toString(a).toCharArray()))
					+ " = " + new String(arr));
		}
	}

	static boolean check(char[] arr) {
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[0] != arr[i]) {
				break;
			}
			if (i == arr.length - 1) {
				String str = new String(arr);
				System.out.println(str + " - " + str + " = 0");
				return false;
			}
		}
		if (arr.length == 4 && arr[0] == '6' && arr[1] == '1' && arr[2] == '7'
				&& arr[3] == '4') {
			return false;
		}
		return true;
	}

	static char[] adjust(char[] arr) {
		if (arr.length >= 4)
			return arr;
		int zero = 4 - arr.length;
		char[] result = new char[4];
		for (int i = 0; i <= zero - 1; i++) {
			result[i] = '0';
		}
		for (int i = zero; i <= 3; i++) {
			result[i] = arr[i - zero];
		}
		return result;
	}
}