package 查找;

public class 二进制中1的个数 {

	public static void main(String[] args) {
		int n = 127;
		System.out.println(Integer.toBinaryString(n));
		int count = 0;
		while (n > 0) {
			count++;
			// n&(n-1)将n的二进制表示中的最低位为1的改为0
			n &= (n - 1);
		}
		System.out.println(count);

	}

}
