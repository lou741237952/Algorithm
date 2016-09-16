package 华为OJ;

import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class 找出字符串中第一个只出现一次的字符 {
	public static void main(String[] f) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		if (str.length() == 1 || str.length() == 0) {
			System.out.println(str);
			return;
		}

		char[] arr = str.toCharArray();
		for (char a : arr) {
			Integer c = map.get(a);
			if (c == null) {
				map.put(a, 1);
			} else {
				map.put(a, c + 1);
			}

		}
		int num = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				num = 1;
				break;

			}
		}
		if (num == 0)
			System.out.println('.');

	}
}