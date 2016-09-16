package algorithm;

public class 字符串反转 {
	public static void main(String[] args) {
		char[] arr = "12456".toCharArray();
		int front = 0;
		int rear = arr.length - 1;
		while (front < rear) {
			char temp = arr[front];
			arr[front] = arr[rear];
			arr[rear] = temp;
			front++;rear--;
		}
		System.out.println(new String(arr));
	}
}
