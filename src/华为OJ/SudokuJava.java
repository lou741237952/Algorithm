package 华为OJ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SudokuJava {
	// 5 9 2 0 0 0 7 6 0
	// 0 1 0 7 0 2 0 0 5
	// 0 0 7 3 0 0 4 1 0
	// 6 2 0 1 0 5 3 0 8
	// 0 0 0 0 4 3 0 2 0
	// 0 3 8 6 2 7 5 9 0
	// 0 0 1 0 3 8 0 4 9
	// 0 8 6 9 0 4 2 5 7
	// 9 4 0 2 7 6 8 0 1

	// 5 9 2 4 8 1 7 6 3
	// 4 1 3 7 6 2 9 8 5
	// 8 6 7 3 5 9 4 1 2
	// 6 2 4 1 9 5 3 7 8
	// 7 5 9 8 4 3 1 2 6
	// 1 3 8 6 2 7 5 9 4
	// 2 7 1 5 3 8 6 4 9
	// 3 8 6 9 1 4 2 5 7
	// 9 4 5 2 7 6 8 3 1

	static Integer[][] arr = new Integer[9][9];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i <= 8; i++) {
			for (int n = 0; n <= 8; n++) {
				arr[i][n] = scan.nextInt();
			}
		}
		deal(0, 0);
		for (int i = 0; i <= 8; i++) {
			for (int n = 0; n <= 8; n++) {
				System.out.print(arr[i][n]);
				if (!(i == 8 && n == 8)) {
					if (n == 8) {
						System.out.println();
					} else {
						System.out.print(" ");
					}
				}
			}
		}
	}

	static boolean deal(int row, int col) {
		int[] index = new int[2];
		if (findNext(row, col, index)) {
			row = index[0];
			col = index[1];
			HashSet<Integer> adj = new HashSet<Integer>(Arrays.asList(0, 1, 2,
					3, 4, 5, 6, 7, 8, 9));
			if (getPossibleAdj(row, col, adj)) {
				for (Integer n : adj) {
					arr[row][col] = n;
					boolean temp = deal(row, col);
					if (temp) {
						return true;
					} else {
						arr[row][col] = 0;
					}
				}
			}
			return false;
		}
		return true;
	}

	static boolean getPossibleAdj(int row, int col, HashSet<Integer> result) {
		for (int i = 0; i <= 8; i++) {
			result.remove(arr[row][i]);
			result.remove(arr[i][col]);
		}
		int A = row / 3;
		int B = col / 3;
		for (int m = A * 3; m <= A * 3 + 2; m++) {
			for (int n = B * 3; n <= B * 3 + 2; n++) {
				result.remove(arr[m][n]);
			}
		}
		return (result.isEmpty()) ? false : true;
	}

	static boolean findNext(int row, int col, int[] result) {
		for (int i = row; i <= 8; i++) {
			int n = (i == row) ? col : 0;
			for (; n <= 8; n++) {
				if (arr[i][n] == 0) {
					result[0] = i;
					result[1] = n;
					return true;
				}
			}
		}
		return false;
	}
}
