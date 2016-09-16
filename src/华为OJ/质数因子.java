package 华为OJ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class 质数因子 {

	public static void main(String[] args) {
		int test = new Scanner(System.in).nextInt();
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!isPrime(test)) {
			for (int i = 2; i <= test && isPrime(i); i++) {
				if (test % i == 0) {
					test /= i;
					result.add(i);
					break;
				}
			}
		}
		result.add(test);
		Iterator<Integer> it = result.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
			if (it.hasNext()) {
				System.out.print(" ");
			}
		}
	}

	private static boolean isPrime(int n) {
		if (n == 1 || n == 2)
			return true;
		if ((n & 1) == 0)
			return false;
		int t = (int) Math.ceil(Math.sqrt(n));
		for (int i = 3; i <= t; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}