package 华为OJ;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class 提取不重复的整数 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		if (str.length() == 0)
			System.out.println("");
		if (str.length() == 1) {
			if (str.equals("0")) {
				System.out.println("");
			} else {
				System.out.println(str);
			}
		}
		StringBuilder d = new StringBuilder(str);
		d.reverse();
		String[] arr = d.toString().split("");
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(arr));
		// System.out.println(set);
		arr = set.toArray(new String[set.size()]);
		for (int i = 0; i <= arr.length - 1; i++) {
			if (arr[i].equals("0") && i != arr.length - 1)
				continue;
			System.out.print(arr[i]);
		}

	}
}