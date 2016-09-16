package 数学问题;

public class 高效求幂 {

	public static void main(String[] args) {
		高效求幂 test = new 高效求幂();
		System.out.println(test.power1(3, 4));
		System.out.println(test.power2(3, 4));
	}

	int power1(int x, int n) {
		if (x == 0)
			return 1;
		if (x == 1)
			return x;
		if ((n & 1) == 0) {
			return power1(x * x, n / 2);
		} else {
			return x * power1(x * x, n / 2);
		}
	}

	int power2(int x, int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		int sum = 1;
		while (n != 1) {
			if ((n & 1) == 0) {
				x *= x;
				n /= 2;
			} else {
				sum *= x;
				x *= x;
				n /= 2;
			}
		}
		return sum * x;
	}
}
