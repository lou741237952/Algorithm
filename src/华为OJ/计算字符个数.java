package 华为OJ;

import java.util.Scanner;

public class 计算字符个数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine().toLowerCase();
		String b = scan.nextLine().toLowerCase();
		String[] arr = a.split("");
		int sum = 0;
		for (String c : arr) {
			if (b.equals(c)) {
				sum++;
			}
		}
		System.out.println(sum);
	}
}