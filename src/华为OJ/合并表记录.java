package 华为OJ;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class 合并表记录 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 1; i <= num; i++) {
			int key = scan.nextInt();
			int value = scan.nextInt();
			Integer temp = map.get(key);
			if (temp == null) {
				map.put(key, value);
			} else {
				map.put(key, value + temp);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "\n" + entry.getValue());
		}
	}
}