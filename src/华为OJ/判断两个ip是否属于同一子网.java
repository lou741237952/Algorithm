package 华为OJ;
import java.util.Scanner;

public class 判断两个ip是否属于同一子网 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] mask = scan.next().split("\\.");
		String[] ip1 = scan.next().split("\\.");
		String[] ip2 = scan.next().split("\\.");
		System.out.println(replace(mask, ip1, ip2));
	}

	static int replace(String[] str1, String[] str2, String[] str3) {
		for (int i = 0; i <= str1.length - 1; i++) {
			int mask = Integer.valueOf(str1[i]);
			int ip1 = Integer.valueOf(str2[i]);
			int ip2 = Integer.valueOf(str3[i]);
			if (mask < 0 || mask > 255 || ip1 < 0 || ip1 > 255 || ip2 < 0
					|| ip2 > 255) {
				return 1;
			}
		}
		for (int i = 0; i <= str2.length - 1; i++) {
			int mask = Integer.valueOf(str1[i]);
			int ip1 = Integer.valueOf(str2[i]);
			int ip2 = Integer.valueOf(str3[i]);
			if ((mask & ip1) != (mask & ip2)) {
				return 2;
			}
		}
		return 0;
	}
}
