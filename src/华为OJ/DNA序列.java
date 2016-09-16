package 华为OJ;

import java.util.Scanner;

public class DNA序列 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] arr = scan.next().toCharArray();
		int n = scan.nextInt();
		int start = 0;
		double ra = 0;
		for (int i = 0; i <= arr.length - n; i++) {
			int GC = 0;
			int AT = 0;
			for (int s = i; s <= i + n - 1; s++) {
				if (arr[s] == 'G' || arr[s] == 'C')
					GC++;
				else
					AT++;
			}
			double ratio = GC / (double) (GC + AT);
			if (ratio > ra) {
				ra = ratio;
				start = i;
			}
		}
		for (int i = start; i <= start + n - 1; i++) {
			System.out.print(arr[i]);
		}

	}

}