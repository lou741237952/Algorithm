package 华为OJ;

import java.math.BigInteger;
import java.util.Scanner;

public class 超长正整数相加 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String n = scan.next();
		String m = scan.next();
		BigInteger b1 = new BigInteger(n);
		BigInteger b2 = b1.add(new BigInteger(m));
		String result = b2.toString();
		System.out.println(result);

	}
}