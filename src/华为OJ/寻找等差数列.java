package 华为OJ;

import java.util.ArrayList;
import java.util.Scanner;

public class 寻找等差数列 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int low = scan.nextInt();
		int high = scan.nextInt();
		for (int i = low; i <= high; i++) {
			if (isPrime(i))
				list.add(i);
		}
		int end = 0;
		ArrayList<Integer> index = new ArrayList<Integer>();
		ArrayList<Integer> indextemp = new ArrayList<Integer>();
		for (int dif = 2; dif <= high - low; dif++) {
			for (int i = 0; i <= list.size() - 1; i++) {
				indextemp.add(i);
				int temp = list.get(i);
				while (list.contains(temp + dif)) {
					indextemp.add(list.indexOf(temp + dif));
					temp += dif;
				}
				if (index.size() <= indextemp.size()) {
					index.clear();
					index.addAll(indextemp);
				}
				indextemp.clear();
			}
		}

		for (int i : index) {
			System.out.println(list.get(i));
		}
	}

	private static boolean isPrime(int n) {
		if (n == 0)
			return false;
		if (n == 1 || n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		int num = (int) Math.sqrt(n) + 1;
		for (int i = 3; i <= num; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}