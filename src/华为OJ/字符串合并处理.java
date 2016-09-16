package 华为OJ;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class 字符串合并处理 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next().concat(scan.next());
		LinkedList<Character> list = new LinkedList<Character>();
		TreeSet<Character> set = new TreeSet<Character>();
		for (int i = 0; i <= str.length() - 1; i += 2) {
			set.add(str.charAt(i));
		}
		list.addAll(set);
		set.clear();
		for (int i = 1; i <= str.length() - 1; i += 2) {
			set.add(str.charAt(i));
		}
		Iterator<Character> it = set.iterator();
		for (int i = 1; i <= str.length() - 1; i += 2) {
			list.add(i, it.next());
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			if ('0' <= c && c <= '9' || 'A' <= c && c <= 'F' || 'a' <= c
					&& c <= 'f') {
				sb.append(reverse(c + "", 16));
			} else {
				sb.append(c);
			}
		}
		System.out.println(sb);
	}

	static String reverse(String str, int n) {
		int i = Integer.parseInt(str, n);
		String temp = Integer.toString(i, 2);
		StringBuilder sb = new StringBuilder();
		for (int m = 1; m <= Math.ceil(Math.log10(n) / Math.log10(2))
				- temp.length(); m++) {
			sb.append("0");
		}
		sb.append(temp);
		sb.reverse();
		int r = Integer.parseInt(sb.toString(), 2);
		return Integer.toString(r, n).toUpperCase();
	}
}
