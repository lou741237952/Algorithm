package map;

import java.util.LinkedList;

public class 上下左右走迷宫 {
	static int length;
	static char[][] board;
	static String word;
	static LinkedList<Character> road = new LinkedList<Character>();

	// [
	// ['A','B','C','E'],
	// ['S','F','E','S'],
	// ['A','D','E','E']
	// ]
	public static void main(String[] args) {
		boolean result = 上下左右走迷宫.exist(new char[][] { { 'A', 'B', 'C', 'E' },
				{ 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } }, "ESEEEFSA");
		System.out.println(road);
	}

	static void core() {
		System.out.println("找到了");
	}

	static public boolean exist(char[][] maze, String target) {
		length = target.length() - 1;
		board = maze;
		word = target;

		for (int i = 0; i <= maze.length - 1; i++) {
			for (int n = 0; n <= maze[0].length - 1; n++) {
				if (move(i, n, 0)) {
					return true;
				} else {
					System.out.println("--------");
				}
			}
		}
		return false;
	}

	static boolean move(int n, int m, int num) {

		// 如果越界、或者达不到逻辑 返回
		if (n == board.length || n == -1 || m == -1 || m == board[0].length) {
			return false;
		}

		System.out.println(board[n][m]);
		if (word.charAt(num) != board[n][m]) {// 包含了已访问过的情况
			return false;
		}
		road.add(board[n][m]);// 记录路径
		// 没有对于访问过的进行返回，因为board[n][m]^=256，
		// 是的原访问路径上的元素修改了，所以往回走一定不会满足条件，以此来处理访问过的情况

		// 符合要求
		if (num == length) {
			core();
			return true;
		}
		board[n][m] ^= 256; // 两次异或处理，可以保存状态，同时通过异或恢复，前提异或后的元素一定不满足搜索逻辑，通过这种方式避免了二维数组保存是否访问
		boolean temp = move(n + 1, m, num + 1) || move(n, m + 1, num + 1)
				|| move(n - 1, m, num + 1) || move(n, m - 1, num + 1);
		board[n][m] ^= 256;// 异或
		return temp;
	}
}
