package 华为OJ;

import java.util.Scanner;

public class 字符串加解密 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] a = scan.nextLine().toCharArray();
		char[] b = scan.nextLine().toCharArray();
		for (int i = 0; i <= a.length - 1; i++) {
			char temp = a[i];
			if ('A' <= temp && temp < 'Z') {
				a[i] = Character.toLowerCase((char) (a[i] + 1));
			}
			if ('Z' == temp) {
				a[i] = 'a';
			}

			if ('a' <= temp && temp < 'z') {
				a[i] = Character.toUpperCase((char) (a[i] + 1));
			}
			if ('z' == temp) {
				a[i] = 'A';
			}
			if ('0' <= temp && temp < '9') {
				a[i] = (char) (temp + 1);
			}
			if ('9' == temp) {
				a[i] = '0';
			}
		}
		for (int i = 0; i <= b.length - 1; i++) {
			char temp = b[i];
			if ('A' < temp && temp <= 'Z') {
				b[i] = Character.toLowerCase((char) (b[i] - 1));
			}
			if ('A' == temp) {
				b[i] = 'z';
			}

			if ('a' < temp && temp <= 'z') {
				b[i] = Character.toUpperCase((char) (b[i] - 1));
			}
			if ('a' == temp) {
				b[i] = 'Z';
			}
			if ('0' < temp && temp <= '9') {
				b[i] = (char) (temp - 1);
			}
			if ('0' == temp) {
				b[i] = '9';
			}
		}
		System.out.println(new String(a));
		System.out.println(new String(b));
	}
}