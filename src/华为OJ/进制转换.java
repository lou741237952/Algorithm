package 华为OJ;

import java.util.Scanner;

public class 进制转换 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine().replaceFirst("0x", "");
		int b = Integer.valueOf(a, 16);
		System.out.println(Integer.toString(b, 10));
	}
}