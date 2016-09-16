package 华为OJ;

import java.util.Scanner;

public class 字符串排序 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = scan.nextLine().toCharArray();
		for (int i = 0; i <= arr.length - 1; i++) {
			if (!isLetter(arr[i]))
				continue;
			int cur = i;
			char temp = arr[i];
			for (int n = i - 1; n >= 0; n--) {
				if (isLetter(arr[n])) {
					if (Character.toLowerCase(arr[n]) > Character
							.toLowerCase(temp)) {
						arr[cur] = arr[n];
						cur = n;
					} else {
						arr[cur] = temp;
						break;
					}
					if (cur == 0)
						arr[0] = temp;
				}
			}

		}
		for (char c : arr) {
			System.out.print(c);
		}
	}

	static boolean isLetter(char ch) {
		if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z')
			return true;
		return false;
	}
}