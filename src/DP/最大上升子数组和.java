package DP;

/**
 * 找到和最大的子数
 * 
 * @author lou
 *
 */
public class 最大上升子数组和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 最大上升子数组和("1,3,5,-3,-7,-8,4,9,6,0,-3,0");
	}

	public 最大上升子数组和(String str) {

		String[] strarr = str.split(",");
		int[] arr = new int[strarr.length];
		for (int i = 0; i <= strarr.length - 1; i++) {
			arr[i] = Integer.parseInt(strarr[i]);
			System.out.print(arr[i] + " "); // String变成int[]
		}

		int curSum = 0, Sum = 0;
		int start = 0, start_temp = 0, end = 0, end_temp = 0;
		for (; end_temp <= arr.length - 1; end_temp++) {
			curSum += arr[end_temp];
			if (curSum > Sum) {
				Sum = curSum;
				start = start_temp;
				end = end_temp;
			} // 每次求到更大的值需要保存首尾序号
			if (curSum < 0) {
				curSum = 0;
				start_temp = end_temp + 1;
			}
		}
		System.out.println("\nstart" + start + " end" + end + " Sum" + Sum);
	}
}
