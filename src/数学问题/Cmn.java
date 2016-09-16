package 数学问题;

public class Cmn {
	static int[] temp;

	public static void main(String[] args) {
		int num = 4;// 选的个数
		temp = new int[num];
		int start = 0;
		int end = 3;
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
			core();
			return;
		}
		if ((end - start + 1) == a) {
			// 如果剩下n个数选n个则每个都选然后停止
			for (int i = 0; i <= a - 1; i++, start++) {
				temp[num - a + i] = start;
			}
			core();
			return;
		}
		// start位置数选，则start+1到end选a-1个，如果不选则start+1到end选a个
		temp[num - a] = start;
		choose(start + 1, end, a - 1, num);
		choose(start + 1, end, a, num);
	}

}
