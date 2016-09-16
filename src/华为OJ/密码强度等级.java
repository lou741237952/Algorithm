package 华为OJ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class 密码强度等级 {
	static HashSet<Character> symbolSet = new HashSet<Character>(Arrays.asList(
			'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-',
			'.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
			'_', '`', '{', '|', '}', '~'));
	static int length = 0;
	static int letter = 0;
	static int number = 0;
	static int symbol = 0;
	static int award = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String pw = scan.nextLine();
		length = lengthScore(pw);
		letter = letterScore(pw);
		number = numberScore(pw);
		symbol = symbolScore(pw);
		award = awardScore();
		System.out.println(getSecurity());
	}

	static int lengthScore(String str) {
		int length = str.length();
		if (length <= 4)
			return 5;
		if (length >= 5 && length <= 7)
			return 10;
		return 25;
	}

	static int letterScore(String str) {
		if (hasLower(str) == false && hasUpper(str) == false)
			return 0;
		if (hasLower(str) == true && hasUpper(str) == false)
			return 10;
		if (hasLower(str) == false && hasUpper(str) == true)
			return 10;
		return 20;
	}

	static boolean hasUpper(String str) {
		for (int i = 0; i <= str.length() - 1; i++) {
			char temp = str.charAt(i);
			if (temp <= 'Z' && temp >= 'A')
				return true;
		}
		return false;
	}

	static boolean hasLower(String str) {
		for (int i = 0; i <= str.length() - 1; i++) {
			char temp = str.charAt(i);
			if (temp <= 'z' && temp >= 'a')
				return true;
		}
		return false;
	}

	static int numberScore(String str) {
		if (numberCount(str) == 0)
			return 0;
		if (numberCount(str) == 1)
			return 10;
		return 20;
	}

	static int numberCount(String str) {
		int sum = 0;
		for (int i = 0; i <= str.length() - 1; i++) {
			char temp = str.charAt(i);
			if (temp <= '9' && temp >= '0')
				sum++;
		}
		return sum;
	}

	static int symbolScore(String str) {
		if (symbolCount(str) == 0)
			return 0;
		if (symbolCount(str) == 1)
			return 10;
		return 25;
	}

	static int symbolCount(String str) {
		int sum = 0;
		for (int i = 0; i <= str.length() - 1; i++) {
			char temp = str.charAt(i);
			if (symbolSet.contains(temp))
				sum++;
		}
		return sum;
	}

	static int awardScore() {
		if (letter > 0 && number > 0 && symbol == 0)
			return 2;
		if (letter > 0 && number > 0 && symbol > 0) {
			if (letter == 20)
				return 5;
			else
				return 3;
		}
		return 0;
	}

	static String getSecurity() {
		int score = length + letter + number + symbol + award;
		if (score >= 90)
			return "VERY_SECURE";
		else if (score >= 80 && score < 90)
			return "SECURE";
		else if (score >= 70 && score < 80)
			return "VERY_STRONG";
		else if (score >= 60 && score < 70)
			return "STRONG";
		else if (score >= 50 && score < 60)
			return "AVERAGE";
		else if (score >= 25 && score < 50)
			return "WEAK";
		else
			return "VERY_WEAK";
	}
}