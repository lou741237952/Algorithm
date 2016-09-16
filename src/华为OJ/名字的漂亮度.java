package 华为OJ;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class 名字的漂亮度 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		String[] arr = new String[num];
		for (int i = 0; i <= num - 1; i++) {
			arr[i] = scan.next().toLowerCase();
		}
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

		for (int i = 0; i <= arr.length - 1; i++) {
			for (int n = 0; n <= arr[i].length() - 1; n++) {
				char temp = arr[i].charAt(n);
				Integer tempnum = map.get(temp);
				if (tempnum != null)
					map.put(temp, tempnum + 1);
				else
					map.put(temp, 1);
			}
			TreeSet<Map.Entry<Character, Integer>> set = new TreeSet<Map.Entry<Character, Integer>>(
					new Comparator<Map.Entry<Character, Integer>>() {
						public int compare(Entry<Character, Integer> o1,
								Entry<Character, Integer> o2) {
							int a = o1.getValue();
							int b = o2.getValue();
							if (a == b) {
								if (o1.getKey() > o2.getKey())
									return 1;
								else if (o1.getKey() < o2.getKey())
									return -1;
								else
									return 0;
							} else if (a < b)
								return 1;
							else
								return -1;
						}
					});
			set.addAll(map.entrySet());
			int sum = 0;
			int start = 26;
			for (Map.Entry<Character, Integer> entry : set) {
				sum += (entry.getValue() * start);
				start--;
			}
			System.out.println(sum);
			map.clear();
		}
	}
}
