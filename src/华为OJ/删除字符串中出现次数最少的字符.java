package 华为OJ;

import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

public class 删除字符串中出现次数最少的字符 {
	public static void main(String[] args) {
		char[] arr = new Scanner(System.in).nextLine().toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : arr) {
			Integer temp = map.get(c);
			if (temp != null) {
				map.put(c, temp + 1);
			} else {
				map.put(c, 1);
			}
		}
		HashSet<Integer> num = new HashSet<Integer>(map.values());
		int min = num.iterator().next();
		for (char c : arr) {
			if (map.get(c) != min) {
				System.out.print(c);
			}
		}
	}
}