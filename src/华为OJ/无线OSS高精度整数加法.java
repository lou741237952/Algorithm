package 华为OJ;

import java.math.BigInteger;
import java.util.Scanner;

public class 无线OSS高精度整数加法 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(new BigInteger(scan.next()).add(new BigInteger(scan
				.next())));
	}
}