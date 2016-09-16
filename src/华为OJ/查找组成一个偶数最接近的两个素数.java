package 华为OJ;

import java.util.HashSet;
import java.util.Scanner;

public class 查找组成一个偶数最接近的两个素数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		int primecount = 0;
		for (int n = 1; n <= test - 1; n += 2) {
			if (isPrime(n)) {
				set.add(n);
			}
		}
		int a = 0;
		int b = 0;
		int dif = Integer.MAX_VALUE;
		for (Integer n : set) {
			if (set.contains(test - n)) {
				int diftemp = Math.abs(test - 2 * n);
				if (diftemp < dif) {
					a = n;
					b = test - n;
					dif = diftemp;
				}
			}
		}
		if (a < b)
			System.out.println(a + "\n" + b);
		else
			System.out.println(b + "\n" + a);

	}

	static boolean isPrime(int n) {
		if (n == 1 || n == 2)
			return true;
		int end = (int) Math.sqrt(n) + 1;
		for (int i = 3; i <= end; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;

	}
}
