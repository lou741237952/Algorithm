package 华为OJ;

import java.util.LinkedList;
import java.util.Scanner;

public class Redraiment的走法最大上升下降子序列 {
	static LinkedList<Integer>[] Incresult;
	static LinkedList<Integer>[] Decresult;

	// 5 3 1 2 5 4
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();// 序列个数
		int[] arr = new int[num];
		for (int i = 0; i <= arr.length - 1; i++) {
			arr[i] = scan.nextInt();
		}
		Incresult = new LinkedList[num];
		Decresult = new LinkedList[num];
		longestIncSeq(arr);
		longestDecSeq(arr);
		for (LinkedList<Integer> i : Incresult) {
			System.out.println(i);
		}
	}

	/**
	 * DP 子问题:f(i)是以arr[i]结尾的最大上升子列
	 * 转移方程:f(i)=i以前的最长上升子列f(n)，而且arr[n]<arr[i](如果等于那就是非下降子列)
	 */
	static void longestIncSeq(int[] data) {
		for (int i = 0; i <= data.length - 1; i++) {
			//子问题以i结尾的上升子列
			LinkedList<Integer> templist = new LinkedList<Integer>();
			if (i == 0) {
				// 等于零直接加入
				templist.add(data[i]);
				Incresult[i] = templist;
			} else {
				int index = 0;
				int num = -1;
				for (int n = 0; n <= i - 1; n++) {
					// 结尾比arr[i]小，且个数最多的子列加上arr[i]组成以f(i)情况
					if (data[n] < data[i] && Incresult[n].size() >= num) {
						//记录最后一位比arr[i]小且个数最多的一个序列，得到序列最后一个数的序号
						num = Incresult[n].size();
						index = n;
					}
				}
				if (num != -1) {
					// 比前面所有数都小
					templist.addAll(Incresult[index]);
				}
				// 更新放入LinkList的数组中保存结果
				templist.add(data[i]);
				Incresult[i] = templist;
			}
		}
	}

	static void longestDecSeq(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			if (i == arr.length - 1) {
				// 等于零直接加入
				list.add(arr[i]);
				Decresult[i] = list;
			} else {
				int index = 0;
				int sum = -1;
				for (int n = i + 1; n <= arr.length - 1; n++) {
					// 结尾比arr[i]小，且个数最多的子列加上arr[i]组成以f(i)情况
					if (arr[n] < arr[i] && Decresult[n].size() >= sum) {
						sum = Decresult[n].size();
						index = n;
					}
				}
				list.add(arr[i]);
				if (sum != -1) {
					// 单独一个数情况
					list.addAll(Decresult[index]);
				}
				// 更新放入LinkList的数组中保存结果
				Decresult[i] = list;

			}
		}
	}
}