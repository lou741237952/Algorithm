package 数学问题;

import java.util.Arrays;

/**
 * 全排列算法
 * 
 * @author lou
 */
public class Amm {
	char[] result;

	public static void main(String args[]) {
		new Amm("1234");
	}

	public Amm(String str) {
		result = str.toCharArray();
		Arrays.sort(result);
		subpermute(result, 0, result.length - 1);
	}

	public void core(char[] list) {
		// 最终数据处理逻辑
		System.out.println(new String(list));
	}

	public void subpermute(char[] list, int low, int high) {
		// 结果保存在原先数组list中
		int i;
		if (low == high) {
			// 只有一个数停止
			core(list); // 打印数组
		} else {
			// 目前low位置的数跟后面每一个数换位，然后对low+1到high全排列
			for (i = low; i <= high; i++) {
				if (compare(list, low, i)) {
					changeitem(list, low, i);
					subpermute(list, low + 1, high);
					changeitem(list, low, i);
				}
			}
		}
	}

	public void changeitem(char[] arr, int a, int b) {
		char temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

	public boolean compare(char[] list, int a, int b) {
		for (int n = a; n < b; n++) {
			if (list[b] == list[n]) {
				return false; // 如果与前面某个数重复返回false
			}
		}
		return true;
	}
}
