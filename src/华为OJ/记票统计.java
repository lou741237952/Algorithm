package 华为OJ;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class 记票统计 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		int n = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			map.put(scan.next(), 0);
		}
		n = scan.nextInt();
		int invalid = 0;
		for (int i = 1; i <= n; i++) {
			String name = scan.next();
			Integer num = map.get(name);
			if (num != null) {
				map.put(name, num + 1);
			} else {
				invalid++;
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		if (invalid != 0) {
			System.out.println("Invalid : " + invalid);
		}
	}
}