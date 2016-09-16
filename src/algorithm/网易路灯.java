package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 网易路灯 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int l = scan.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i <= n - 1; i++) {
				arr.add(scan.nextInt());
			}
			for (int i : arr) {
				if (i > l) {
					arr.remove(i);
				}
			}
			Collections.sort(arr);
			Integer[] a = arr.toArray(new Integer[arr.size()]);
			double dis = Math.max(a[0], l - a[a.length - 1]);
			for (int i = 0; i <= a.length - 1; i++) {
				if (i == a.length - 1) {
					break;
				}
				double disTemp = 0.5 * (a[i + 1] - a[i]);
				dis = (disTemp > dis) ? disTemp : dis;
			}
			System.out.println(String.format("%.2f", dis));
		}
	}
}
