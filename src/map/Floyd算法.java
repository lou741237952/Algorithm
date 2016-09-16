package map;

public class Floyd算法 {
	// 求两点间最短路径
	static int road[][];
	static int dis[][];
	static int adj[][];

	public static void main(String[] args) {
		adj = new int[][] { { 0, 1, 3, 3 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 0 } };
		road = new int[adj.length][adj[0].length];
		dis = new int[adj.length][adj[0].length];
		Prim();
		printRoad(0, 2);
		System.out.println(2);
		print();
	}

	static void Prim() {
		// 赋值
		for (int i = 0; i <= adj.length - 1; i++) {
			for (int m = 0; m <= adj[0].length - 1; m++) {
				dis[i][m] = adj[i][m];
				road[i][m] = -1;
			}
		}
		// 遍历每个点（经过此点），对这个点遍历开始和结束点，如果经过此点距离更短，则更新路径，用二维数组保存
		for (int k = 0; k <= adj.length - 1; k++) {
			for (int m = 0; m <= adj.length - 1; m++) {
				if (dis[m][k] == 0) {
					continue;
				}
				for (int n = 0; n <= adj[0].length - 1; n++) {
					if (dis[k][n] == 0) {
						continue;
					}
					if (dis[m][k] + dis[k][n] < dis[m][n]) {
						dis[m][n] = dis[m][k] + dis[k][n];
						System.out.printf(
								"dis[%s][%s] = dis[%s][%s] + dis[%s][%s]\n", m,
								n, m, k, k, n);
						road[m][n] = k;
					}
				}
			}
		}
	}

	static void printRoad(int start, int stop) {
		System.out.print(start + " ");
		if (road[start][stop] == -1) {
			return;
		}
		printRoad(start, road[start][stop]);
		printRoad(road[start][stop], stop);
	}

	static void print() {
		for (int i = 0; i <= adj.length - 1; i++) {
			for (int m = 0; m <= adj[0].length - 1; m++) {
				System.out.print(dis[i][m] + "  ");
			}
			System.out.println();
		}
	}
}
