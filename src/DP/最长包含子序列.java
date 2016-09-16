package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 最长包含子序列 {

	public static void main(String[] args) {
		String s = "bba";
		String t = "ab";
		System.out.println(minWindow(s, t));
	}

	static public String minWindow(String s, String t) {
		int start = 0;
		int end = 0;
		int count = s.length() + 1;
		int tempstart = 0;
		int tempend = 0;
		int num = t.length();
		HashMap<Character, Integer> numMap = new HashMap<Character, Integer>();// 保存每个数最多的个数
		Character[] arr = new Character[t.length()];
		for (int i = 0; i <= arr.length - 1; i++) {
			Character temp = t.charAt(i);
			if (numMap.containsKey(temp)) {
				int n = numMap.get(temp);
				numMap.put(temp, n + 1);
			} else {
				numMap.put(temp, 1);
			}
			arr[i] = t.charAt(i);
		}
		HashSet<Character> base = new HashSet<Character>(Arrays.asList(arr)); // 对照
		LinkedList<Character> list = new LinkedList<Character>(); // 保存字符
		HashMap<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>(); // 记录index

		while (tempend <= s.length() - 1 && !base.contains(s.charAt(tempend))) {
			tempend++;
		}
		tempstart = tempend;
		for (; tempend <= s.length() - 1; tempend++) {
			Character temp = s.charAt(tempend);
			if (base.contains(temp)) {
				// 符合要求
				LinkedList<Integer> templist;
				if (map.containsKey(temp)) {
					templist = map.get(temp);
					if (templist.size() >= numMap.get(temp)) {
						templist.poll();
						list.remove(temp);
						map.remove(temp);
					}
				} else {
					templist = new LinkedList<Integer>();
				}
				list.add(temp);
				templist.add(tempend);
				map.put(temp, templist);
				// System.out.println(list + " " + map);
				// 目标找到
				if (list.size() == num) {
					char c = list.poll();
					LinkedList<Integer> templist2 = map.get(c);
					tempstart = templist2.poll();
					if (templist2.isEmpty()) {
						map.remove(c);
					}
					if (tempend - tempstart + 1 < count) {
						start = tempstart;
						end = tempend;
						count = tempend - tempstart + 1;
					}
					// System.out.println(tempstart + " " + tempend);
				}
			}
		}
		return (count == s.length() + 1) ? "" : s.substring(start, end + 1);
	}
}
