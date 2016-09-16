package 华为OJ;
import java.util.Scanner;

public class 字符串分割 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 1; i <= num; i++) {
			exe(scan.next());
		}
	}

	static void exe(String s) {
		char[] temp = s.toCharArray();
		int num = s.length();
		int n = num / 8;
		for (int i = 0; i <= n * 8 - 1; i++) {
			System.out.print(temp[i]);
			if ((i + 1) % 8 == 0)
				System.out.println();
		}
		for (int i = 1; i <= 8; i++) {
			if (i + n * 8 - 1 <= num - 1) {
				System.out.print(temp[i + n * 8 - 1]);
			} else {
				System.out.print("0");
			}

		}
		System.out.println();
	}
}
