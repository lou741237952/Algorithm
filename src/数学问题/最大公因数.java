package 数学问题;

public class 最大公因数 {

	public static void main(String[] args) {
		最大公因数 test = new 最大公因数();
		System.out.println(test.comFactor1(24, 16));
		System.out.println(test.comFactor2(24, 16));
	}

	int comFactor1(int a, int b) {
		while (b != 0) {
			int reminder = a % b;
			a = b;
			b = reminder;
		}
		return a;
	}
	int comFactor2(int a, int b){
		if(b==0) return a;
		return comFactor2(b, a%b);
	} 
}
