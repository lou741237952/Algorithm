package 华为OJ;

import java.util.Scanner;

public class 整数与IP地址间的转换 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(toIP(scan.next()) + "\n" + toTen(scan.next()));
	}

	static int toIP(String str) {
		String[] arr = str.split("\\.");
		int result = 0;
		for (int i = 0; i <= arr.length - 1; i++) {
			result += (Integer.valueOf(arr[i]) << ((arr.length - 1 - i) * 8));
		}
		return result;
	}

	static String toTen(String str) {
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(str);
		for (int i = 3; i >= 0; i--) {
			sb.append((n >> i * 8) & 0xFF);
			if (i != 0) {
				sb.append(".");
			}
		}
		return sb.toString();
	}
}