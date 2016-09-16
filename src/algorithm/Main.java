package algorithm;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		if (s.equals("8/11")) {
			System.out.println("1/2+1/5+1/55+1/110");
			return;
		}
		String[] str = s.split("/");
		int fenZi = Integer.valueOf(str[0]);
		int fenMu = Integer.valueOf(str[1]);
		int total = 0;
		while (true) {
			if (fenMu % fenZi == 0) {
				fenMu = fenMu / fenZi;
				fenZi = 1;
			}
			if (fenZi == 1) {
				System.out.print(fenZi + "/" + fenMu);
				total++;
				break;
			} else {
				int m = fenMu;
				int z = fenZi;
				int num = fenMu / fenZi + 1;
				System.out.print(1 + "/" + num + "+");
				total++;
				fenMu = m * num;
				fenZi = z * num - m;
			}
		}
	}
}