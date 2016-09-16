package 华为OJ;

import java.util.Scanner;

public class 参数解析 {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= str.length() - 1;) {
			char temp = str.charAt(i);
			if (temp == '“') {
				i++;
				while (str.charAt(i) != '”') {
					sb.append(str.charAt(i));
					i++;
				}
				i++;
			} else if (temp == ' ') {
				i++;
				sb.append('|');
			} else {
				i++;
				sb.append(temp);
			}
		}
		String[] result = sb.toString().split("\\|");
		System.out.print(result.length);
		for (int i = 0; i <= result.length - 1; i++) {
			System.out.print("\n" + result[i]);
		}
	}
}
