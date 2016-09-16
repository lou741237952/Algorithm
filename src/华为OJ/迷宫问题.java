package 华为OJ;
/**
 *  	0, 1, 0, 0, 0,

        0, 1, 0, 1, 0,

        0, 0, 0, 0, 0,

        0, 1, 1, 1, 0,

        0, 0, 0, 1, 0,
        走迷宫问题左上角到右下角，1为障碍
   A*算法
   输入数据:5 5 0 1 0 0 0 0 1 0 1 0 0 0 0 1 0 0 1 1 1 0 0 0 0 1 0
 */
import java.util.HashMap;
import java.util.Scanner;

public class 迷宫问题 {
	private static int m;
	private static int n;
	private static int[][] arr;
	private static boolean[][] tag;
	private static HashMap<String, String> road = new HashMap<String, String>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		arr = new int[m][n];
		tag = new boolean[m][n];
		for (int a = 0; a <= m - 1; a++) {
			for (int b = 0; b <= n - 1; b++) {
				arr[a][b] = scan.nextInt();
				tag[a][b] = (arr[a][b] == 0) ? true : false;
			}
		}
		go(0, 0);
		printRoad(Road(m - 1, n - 1));
	}

	private static void go(int a, int b) {
		// System.out.println(Road(a, b));
		tag[a][b] = false;// 标记处理
		if (a == m - 1 && b == n - 1) {
			// 到终点返回
			return;
		}
		if ((b == n - 1 || tag[a][b + 1] == false)// 右侧不能走
				&& (a == m - 1 || tag[a + 1][b] == false)// 下方不能走
				&& (a == 0 || tag[a - 1][b] == false)// 上方不能走
				&& (b == 0 || tag[a][b - 1] == false)) { // 左侧不能走
			// 如果走到死路且不是终点
			road.put(Road(a, b), null);
		} else {
			if (a < m - 1 && tag[a + 1][b]) {
				// 往下走
				road.put(Road(a + 1, b), Road(a, b));
				go(a + 1, b);
			}
			if (b < n - 1 && tag[a][b + 1]) {
				// 往右走
				road.put(Road(a, b + 1), Road(a, b));
				go(a, b + 1);
			}
			if (a > 0 && tag[a - 1][b]) {
				// 往上走
				road.put(Road(a - 1, b), Road(a, b));
				go(a - 1, b);
			}
			if (b > 0 && tag[a][b - 1]) {
				// 往左走
				road.put(Road(a, b - 1), Road(a, b));
				go(a, b - 1);
			}
		}
	}

	private static String Road(int a, int b) {
		return "(" + a + "," + b + ")";
	}

	private static void printRoad(String end) {
		if (end.equals(Road(0, 0))) {
			System.out.println(Road(0, 0));
		} else {
			// System.out.println(end);//反向回溯，与正向的区别在于迭代前后输出
			printRoad(road.get(end));
			System.out.println(end);
		}
	}
}