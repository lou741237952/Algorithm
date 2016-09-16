package 华为OJ;

/**
 * 素数伴侣:两数之和为素数
 * 判断一组数中最大素数伴侣个数
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 素数伴侣 {
	static int num = 0;
	static Integer[] less;
	static Integer[] more;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			int temp = scan.nextInt();
			if ((temp & 1) == 1) {
				odd.add(temp);
			} else {
				even.add(temp);
			}
		}
		// 分为奇偶两组
		if (odd.size() <= even.size()) {
			less = odd.toArray(new Integer[odd.size()]);
			more = even.toArray(new Integer[even.size()]);
		} else {
			more = odd.toArray(new Integer[odd.size()]);
			less = even.toArray(new Integer[even.size()]);
		}
		permute(0, less.length - 1);// 将数量少的一组进行全排列
		System.out.println(num);
	}

	private static void count() {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(more));
		// 数量少的一组每个元素与多的一组比对，是素数count++
		for (int i = 0; i <= less.length - 1; i++) {
			for (Integer temp : list) {
				if (temp != -1 && isPrime(less[i] + temp)) {
					count++;
					list.set(list.indexOf(temp), -1);
				}
			}
		}
		num = Math.max(count, num);
	}

	private static void permute(int low, int high) {
		int i;
		if (low == high) {
			count();// 全排列后跳转到count()核心方法
		} else {
			for (i = low; i <= high; i++) {
				if (compare(low, i)) {
					changeitem(low, i);
					permute(low + 1, high);
					changeitem(low, i);
				}
			}
		}
	}

	private static void changeitem(int a, int b) {
		int temp = less[b];
		less[b] = less[a];
		less[a] = temp;
	}

	private static boolean compare(int a, int b) {
		boolean bool = true;
		for (int n = a; n < b; n++) {
			if (less[b] == less[n]) {
				bool = false; // 如果与前面某个数重复返回false
			}
		}
		return bool;
	}

	private static boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
