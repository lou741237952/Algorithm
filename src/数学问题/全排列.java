package 数学问题;

public class 全排列 {
	static int[] data;

	public static void main(String[] args) {
		data = new int[] { 1, 2, 3 };
		subpermute(0, data.length - 1);
	}

	static void core() {
		// 最终数据处理逻辑
		for (int i : data) {
			System.out.print(i);
		}
		System.out.println();
	}

	static void subpermute(int low, int high) {
		// 结果保存在原先数组list中
		int i;
		if (low == high) {
			// 只有一个数停止
			core(); // 打印数组
		} else {
			// 目前low位置的数跟后面每一个数换位，然后对low+1到high全排列
			for (i = low; i <= high; i++) {
				if (compare(low, i)) {
					changeitem(low, i);
					subpermute(low + 1, high);
					changeitem(low, i);
				}
			}
		}
	}

	static void changeitem(int a, int b) {
		int t = data[b];
		data[b] = data[a];
		data[a] = t;
	}

	static boolean compare(int a, int b) {
		for (int n = a; n < b; n++) {
			if (data[b] == data[n]) {
				return false; // 如果与前面某个数重复返回false
			}
		}
		return true;
	}
}
