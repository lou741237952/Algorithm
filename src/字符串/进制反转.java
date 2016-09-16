package 字符串;

public class 进制反转 {

	public static void main(String[] args) {
		System.out.println(reverse("7", 16));
	}

	static String reverse(String str, int n) {
		int i = Integer.parseInt(str, n);
		String temp = Integer.toString(i, 2);
		StringBuilder sb = new StringBuilder();
		for (int m = 1; m <= Math.ceil(Math.log10(n) / Math.log10(2))
				- temp.length(); m++) {
			sb.append("0");
		}
		sb.append(temp);
		sb.reverse();
		int r = Integer.parseInt(sb.toString(), 2);
		return Integer.toString(r, n);
	}

}