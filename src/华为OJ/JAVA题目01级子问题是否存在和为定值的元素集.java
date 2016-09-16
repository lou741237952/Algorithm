package 华为OJ;

import java.util.ArrayList;
import java.util.Scanner;

public class JAVA题目01级子问题是否存在和为定值的元素集 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		ArrayList<Integer> test = new ArrayList<Integer>();
		int fiveSum = 0;
		int threeSum = 0;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int temp = scan.nextInt();
			if (temp % 5 == 0) {
				fiveSum += temp;
			} else if (temp % 3 == 0) {
				threeSum += temp;
			} else {
				test.add(temp);
				sum += temp;
			}
		}
		int complement = Math.abs(fiveSum - threeSum);
		sum -= complement;
		if (sum < 0 || sum % 2 != 0) {
			System.out.println(false);
			return;
		}
		int target = sum / 2;
		test.add(-1 * complement);

		System.out.println(find(test.toArray(new Integer[test.size()]), 0,
				target));
	}

	// 判断数组中是否有和为定值的元素集合(背包问题)
	static boolean find(Integer[] arr, int start, int target) {
		if (arr[start] == target) { // 如果起始数正好为目标和，返回true
			return true;
		}
		if (start == arr.length - 1) {// 到达最后且最后一个数不为目标和，返回false
			return false;
		}
		return (find(arr, start + 1, target) || find(arr, start + 1, target
				- arr[start])); // 返回包含次数结果或者不包含次数结果
	}

}