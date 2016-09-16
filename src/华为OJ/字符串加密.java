package 华为OJ;

import java.util.HashMap;
import java.util.Scanner;

public class 字符串加密 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String key = scan.nextLine();
		char[] arr = scan.nextLine().toCharArray();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		int count = 0;
		for (int i = 0; i <= key.length() - 1; i++) {
			char temp = key.charAt(i);
			if (!map.containsValue(temp)) {
				map.put((char) ('A' + count), Character.toUpperCase(temp));
				map.put((char) ('a' + count), Character.toLowerCase(temp));
				count++;
			}
		}
		int index = 0;
		for (int i = map.size() / 2; i <= 25; i++) {
			while (map.containsValue((char) ('A' + index))) {
				index++;
			}
			map.put((char) ('A' + i), (char) ('A' + index));
			map.put((char) ('a' + i), (char) ('a' + index));
		}
		for (char a : arr) {
			Character temp = map.get(a);
			if (temp != null) {
				System.out.print(temp);
			} else {
				System.out.print(a);
			}
		}
	}
}