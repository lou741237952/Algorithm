package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 桶排序 {
	static LinkedList<Integer>[] bucket = new LinkedList[10];// 桶0-9
	static LinkedList<Integer> arr;
	static LinkedList<Integer> result = new LinkedList<Integer>();

	public static void main(String[] args) {
		arr = new LinkedList<Integer>(Arrays.asList(4, 3, 2, 1, 95, 53, 32, 21,
				10, 965, 684, 385, 219, 100));
		bucketSort();
	}

	static void bucketSort() {
		// 按照百位数放入桶中
		for (Integer i : arr) {
			int temp = i / 100;
			if (bucket[temp] == null) {
				bucket[temp] = new LinkedList<Integer>();
			}
			bucket[temp].add(i);
		}
		// 对每个桶内部进行排序
		for (LinkedList<Integer> list : bucket) {
			if (list != null) {
				Collections.sort(list);
				result.addAll(list);
			}
			System.out.println(list);
		}
		System.out.println("\n" + result);
	}

}
