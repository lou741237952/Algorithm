package 华为OJ;

import java.util.Scanner;

public class 矩阵乘法 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int[][] A = new int[a][b];
		int[][] B = new int[b][c];
		for (int x = 0; x <= a - 1; x++) {
			for (int y = 0; y <= b - 1; y++) {
				A[x][y] = scan.nextInt();
			}
		}
		for (int x = 0; x <= b - 1; x++) {
			for (int y = 0; y <= c - 1; y++) {
				B[x][y] = scan.nextInt();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n <= a - 1; n++) {
			for (int m = 0; m <= c - 1; m++) {
				int sum = 0;
				for (int z = 0; z <= b - 1; z++) {
					sum += (A[n][z] * B[z][m]);
				}
				sb.append(sum );
				if(m!=c-1) sb.append(" ");
				else sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}