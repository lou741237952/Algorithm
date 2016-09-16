package 华为OJ;

import java.util.HashMap;
import java.util.Scanner;

public class 人民币转换 {
	static HashMap<Character, Character> map = new HashMap<Character, Character>();
	static HashMap<Integer, Character> unit = new HashMap<Integer, Character>();
	static HashMap<Integer, String> supUnit = new HashMap<Integer, String>();
	static {
		map.put('0', '零');
		map.put('1', '壹');
		map.put('2', '贰');
		map.put('3', '叁');
		map.put('4', '肆');
		map.put('5', '伍');
		map.put('6', '陆');
		map.put('7', '柒');
		map.put('8', '捌');
		map.put('9', '玖');
		unit.put(0, '元');
		unit.put(1, '拾');
		unit.put(2, '佰');
		unit.put(3, '仟');
		supUnit.put(0, "元");
		supUnit.put(1, "万");
		supUnit.put(2, "亿");
		supUnit.put(3, "万亿");
	}

	public static void main(String[] args) {
		// 最大到一万万亿元-1
		// Scanner scan = new Scanner(System.in);
		// String str = scan.nextLine();
		String str = "11000.00";
		String result = transRMB(str);
		System.out.println("人民币" + result);
	}

	static String transRMB(String str) {
		StringBuilder sb = new StringBuilder();
		int indexDot = str.indexOf('.');
		String afterDot = null;
		if (indexDot != -1) {
			// 截取小数点前面部分
			afterDot = str.substring(indexDot + 1, str.length());
			str = str.substring(0, indexDot);
		}
		int changeUnit = (int) Math.ceil(str.length() / 4.0);// 确定有几个大单位
		int stop = str.length() - 1 - str.length() / 4 * 4;// 最前部分不足4个的块中最后一个
		stop = (stop < 0) ? stop + 4 : stop;// 只有千级时stop会得到-1,需调整
		sb.append(printThousands(str, 0, stop));// 处理最前面千级范围部分
		// 处理整数部分
		if (changeUnit == 1) {
			// 千级范围
			sb.append("元");
		} else {
			// 大于千级F
			sb.append(supUnit.get(changeUnit - 1));
			for (int i = 1; i <= changeUnit - 1; i++) {
				sb.append(printThousands(str, stop + 1 + (i - 1) * 4, stop + 1
						+ (i - 1) * 4 + 3));
				boolean allZero = true;
				// 判断是否全零
				for (int n = 0; n <= 3; n++) {
					if (str.charAt(stop + 1 + (i - 1) * 4 + n) != '0') {
						allZero = false;
						break;
					}
				}
				if (!allZero || (changeUnit - i - 1 == 0)) {
					sb.append(supUnit.get(changeUnit - i - 1));// 加入单位
				}

			}
		}
		// 除去前后的0
		if (str.length() != 1) {
			if (sb.charAt(0) == '零')
				sb.deleteCharAt(0);
			int temp = sb.indexOf("元") - 1;
			if (sb.charAt(temp) == '零')
				sb.deleteCharAt(temp);
		}
		if (indexDot == -1) {
			// 没有小数点
			sb.append('整');
		} else {
			String temp = printCents(afterDot, 0);
			sb.append(temp);
		}
		String result = sb.toString();
		if (result.indexOf("壹拾")==1) {
			result = result.substring(1);
		}
		return removeInsideZero(result);
	}

	static String removeInsideZero(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= str.length() - 1;) {
			sb.append(str.charAt(i));
			if (str.charAt(i) == '零') {
				while (i <= str.length() - 1 && str.charAt(i) == '零') {
					i++;
				}
			} else {
				i++;
			}

		}
		return sb.toString();
	}

	static String printThousands(String str, int start, int stop) {
		// 防止100 0100 变成壹佰零万零壹佰元整
		boolean doubleZero = (start - 1 != -1 && str.charAt(start - 1) == '0') ? true
				: false;
		// stop为小数点前一位 start最为最高位(最多为千位)
		StringBuilder sb = new StringBuilder();
		int firstNotZero = start;
		for (; firstNotZero <= stop; firstNotZero++) {
			if (str.charAt(firstNotZero) != '0')
				break;
		}
		if (firstNotZero == stop + 1) {
			// 全部是0情况
			if (start - 4 >= 0) {
				// 检查之前4个是不是全为零
				for (int i = 1; i <= 4; i++) {
					if (str.charAt(start - i) != '0') {
						return (doubleZero) ? "零" : "";
					}
				}
				return "";
			}

		}
		// 高位有零打出0
		if (firstNotZero != start) {
			sb.append("零");
		}
		for (int i = firstNotZero; i <= stop;) {
			if (str.charAt(i) == '0') {
				// 有零的情况
				i++;
				while (i <= stop && str.charAt(i) == '0') {
					i++;// 找到下一个不为零的数
				}
				if (i != stop + 1) {
					// 多个零只打印一个零
					sb.append("零");
				}
			}
			if (i != stop + 1) {
				// 显示对应汉字和单位
				sb.append(map.get(str.charAt(i)));
				if (i != stop)
					sb.append(unit.get(stop - i));// 个位数的时候不显示单位
				i++;
			}

		}
		return sb.toString();
	}

	static String printCents(String str, int start) {
		StringBuilder sb = new StringBuilder();
		char a = str.charAt(start);
		char b = str.charAt(start + 1);
		if (a == '0' && b == '0') {
			return "整";
		}
		if (a != '0' && b != '0') {
			sb.append(map.get(a) + "角");
			sb.append(map.get(b) + "分");
		}
		if (a == '0' && b != '0') {
			sb.append("零");
			sb.append(map.get(b) + "分");
		}
		if (a != '0' && b == '0') {
			sb.append(map.get(a) + "角");
		}
		return sb.toString();
	}
}