package 华为OJ;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

public class 字符统计 {
	public static void main(String[] args) {
		char[] test = new Scanner(System.in).nextLine().toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i <= test.length - 1; i++) {
			if ((test[i] >= 'A' && test[i] <= 'Z')
					|| (test[i] >= 'a' && test[i] <= 'z')
					|| (test[i] >= '0' && test[i] <= '9') || test[i] == ' ') {
				Integer temp = map.get(test[i]);
				if (temp == null) {
					map.put(test[i], 1);
				} else {
					map.put(test[i], temp + 1);
				}
			}
		}
		TreeSet<Map.Entry<Character, Integer>> set = new TreeSet<Map.Entry<Character, Integer>>(
				new Comparator<Map.Entry<Character, Integer>>() {

					@Override
					public int compare(Entry<Character, Integer> o1,
							Entry<Character, Integer> o2) {
						int a = o1.getValue();
						int b = o2.getValue();
						if (a > b)
							return -1;
						if (a < b)
							return 1;
						else {
							char m = o1.getKey();
							char n = o2.getKey();
							if (m > n)
								return 1;
							if (m < n)
								return -1;
							else
								return 0;
						}
					}
				});
		set.addAll(map.entrySet());
		for (Map.Entry<Character, Integer> entry : set) {
			System.out.print(entry.getKey());
		}
	}
}
