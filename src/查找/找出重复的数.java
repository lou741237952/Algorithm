package 查找;

public class 找出重复的数 {

	public static void main(String[] args) {
		new 找出重复的数();

	}

	找出重复的数() {

		System.out.println(buildarr(200000000, 100000000));
		System.out.println(Integer.MAX_VALUE);

	}

	private int buildarr(int end, int repeat) {
		int[] arr = new int[end + 2];
		for (int i = 0; i <= repeat; i++) {
			arr[i] = i;
		}
		for (int i = repeat; i <= end; i++) {
			arr[i + 1] = i;
		}

		// for(int a:arr){
		// System.out.println(a);
		// }
		return findRepeat(arr);
	}

	private int findRepeat(int[] arr) {
		int length = arr.length;
		int origin = 0;
		int result = arr[0];
		for (int i = 1; i <= length - 2; i++) {
			origin ^= i;
		}
		for (int i = 1; i <= length - 1; i++) {
			result ^= arr[i];
		}
		int re = origin ^ result;
		return re;
	}
}
