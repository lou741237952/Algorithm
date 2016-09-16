package 华为OJ;

import java.util.Scanner;
import java.util.regex.Pattern;

public class 坐标移动 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] string = scan.nextLine().split(";");
		int a = 0, b = 0;
		for (int i = 0; i <= string.length - 1; i++) {
			if (Pattern.matches("[ASWD][0-9]+$", string[i])) {
				switch (string[i].charAt(0)) {
				case 'A':
					a -= Integer.valueOf(string[i].substring(1,
							string[i].length()));
					break;
				case 'S':
					b -= Integer.valueOf(string[i].substring(1,
							string[i].length()));
					break;
				case 'W':
					b += Integer.valueOf(string[i].substring(1,
							string[i].length()));
					break;
				case 'D':
					a += Integer.valueOf(string[i].substring(1,
							string[i].length()));
					break;
				}
			}
		}
		System.out.println(a + "," + b);
	}
}