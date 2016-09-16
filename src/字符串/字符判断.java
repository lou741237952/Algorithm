package 字符串;

public class 字符判断 {

	public static void main(String[] args) {
		System.out.println(isDigit('a'));
		System.out.println(isLetter('0'));
	}

	static boolean isDigit(char c) {
		return Character.isDigit(c);
	}

	static boolean isUpperCase(char c) {
		return Character.isUpperCase(c);
	}

	static boolean isLowerCase(char c) {
		return Character.isLowerCase(c);
	}

	static boolean isLetter(char c) {
		return Character.isLetter(c);
	}
}
