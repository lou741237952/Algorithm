package algorithm;

import java.util.Scanner;

public class 放歌曲到CD {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();// 歌曲数量
		int s = scan.nextInt();// 每首歌秒数
		int L = scan.nextInt();// CD数量
		int subSum = s;
		int i = 2;
		for (;; i++) {
			if (i % 13 == 0) {
				// 13的情况
				if (subSum + 2 + 2 * s <= L) {
					subSum += (2 + 2 * s);
					i++;
				} else {
					i--;
					break;
				}
			} else {
				// 非13情况
				if (subSum + 1 + s <= L) {
					subSum += (1 + s);
				} else {
					i--;
					break;
				}
			}

		}
		int result = (n % i == 0) ? n / i : n / i + 1;
		System.out.println("每张CD可以放的歌曲数为：" + i + "\n总共需要CD为:" + result);
	}

}
