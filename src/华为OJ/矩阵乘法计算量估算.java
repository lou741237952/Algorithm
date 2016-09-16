package 华为OJ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class 矩阵乘法计算量估算 {
	static int count = 0;
	static Map<Character, String> map = new HashMap<Character, String>();
	static int sum = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 0; i <= num - 1; i++) {
			map.put((char) ('A' + i), scan.next() + " " + scan.next());
		}
		f(scan.next());
		System.out.println(sum);
	}

	static void f(String str) {
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i = 0; i <= str.length() - 1; i++) {
			char c = str.charAt(i);
			if (c != ')') {
				list.addFirst(c);
			} else {
				char ch = list.poll();
				String a = map.get(ch);
				String b = map.get(list.poll());
				list.poll();
				String bb = b.substring(0, b.indexOf(" "));
				String mid = b.substring(b.indexOf(' ') + 1, b.length());
				String aa = a.substring(a.indexOf(" ") + 1, a.length());
				String temp = bb + " " + aa;
				sum += Integer.valueOf(bb) * Integer.valueOf(mid)
						* Integer.valueOf(aa);
				map.put(ch, temp);
				list.addFirst(ch);
			}
		}
	}
}