package 数学问题;

public class Amn {
	static int[] temp;

	public static void main(String[] args) {
		int num = 2;// 选的个数
		temp = new int[num];
		int start = 1;
		int end = 4;
		System.out.println(start + "到" + end + "选" + num + "个");
		choose(start, end, num, num);
	}

	static void core() {
		// 最终数据处理逻辑
		for (int i : temp) {
			System.out.print(i);
		}
		System.out.println();
	}

	static void choose(int start, int end, int a, int num) {
		// 从start到end中选取num个数 迭代中选到a个数
		if (a == 0) {
			// 如果选的个数为零停止
			subpermute(0, num - 1);
			return;
		}
		if ((end - start + 1) == a) {
			// 如果剩下n个数选n个则每个都选然后停止
			for (int i = a - 1; i >= 0; i--, start++) {
				temp[num - 1 - i] = start;
			}
			subpermute(0, num - 1);
			System.out.println();
			return;
		}
		// start位置数选，则start+1到end选a-1个，如果不选则start+1到end选a个
		temp[num - a] = start;
		choose(start + 1, end, a - 1, num);
		choose(start + 1, end, a, num);
	}

	// -----------------------------------全排列-------------------------------------
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
		int t = temp[b];
		temp[b] = temp[a];
		temp[a] = t;
	}

	static boolean compare(int a, int b) {
		for (int n = a; n < b; n++) {
			if (temp[b] == temp[n]) {
				return false; // 如果与前面某个数重复返回false
			}
		}
		return true;
	}
}
