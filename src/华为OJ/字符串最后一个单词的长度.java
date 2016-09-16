package 华为OJ;

import java.util.Scanner;

public class 字符串最后一个单词的长度 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().split(" +");
		System.out.println(str[str.length - 1].length());

	}
}