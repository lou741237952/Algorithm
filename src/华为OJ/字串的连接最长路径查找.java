package 华为OJ;

import java.util.Scanner;

public class 字串的连接最长路径查找 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(scan.next());
		String test = scan.nextLine();

		while (true) {
			String temp = "";
			for (int i = sb.length() - 1; i >= 0; i--) {
				temp = sb.substring(i, sb.length());
				int index = test.indexOf(temp);
				if (index == -1) {
					temp = sb.substring(i + 1, sb.length());
					break;
				}
			}
			int start = test.indexOf(temp) + temp.length();
			test = test.substring(start, test.length());
			if (test.contains(" ")) {
				sb.append(test.substring(0, test.indexOf(" ")));
			} else {
				sb.append(test);
				break;
			}
		}
		System.out.println(sb);
	}
}