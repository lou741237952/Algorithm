package 华为OJ;

import java.util.Scanner;

public class 汽水瓶 {
	static int sum = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int temp = scan.nextInt();
		while (temp != 0) {
			drink(temp);
			System.out.println(sum);
			sum = 0;
			temp = scan.nextInt();
		}
	}

	static void drink(int n) {
		int reminder = n % 3;
		int result = n / 3;
		sum += result;
		int next = reminder + result;
		if (next == 1 || next == 0) {
			return;
		} else if (next == 2) {
			sum++;
			return;
		} else {
			drink(next);
		}
	}
}
