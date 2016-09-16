package 华为OJ;

import java.util.Scanner;

public class 按字节截取字符串 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = scan.next().toCharArray();
		int num = scan.nextInt();

		int count = 0;
		for (int i = 0; i <= arr.length - 1 && count <= num; i++) {
			char temp = arr[i];
			if (Character.toString(temp).matches("[A-Za-z]")) {
				count += 1;
			} else {
				count += 2;
			}
			if (count != num + 1)
				System.out.print(arr[i]);
		}
	}
}
