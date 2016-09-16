package 华为OJ;

import java.util.Scanner;

public class 百钱买百鸡问题 {

	public static void main(String[] args) {
		new Scanner(System.in).next();
		int x, y, z;
		for (x = 0;; x++) {
			if ((100 - 7 * x) % 4 == 0) {
				y = (100 - 7 * x) / 4;
				if (y >= 0) {
					z = 100 - x - y;
					System.out.print(x + " " + y + " " + z + "\n");
				}
				if (x * 7 > 100)
					return;
			}
		}
	}
}
