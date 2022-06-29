import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num + 1];
		int[] dp = new int[num + 1];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(dp[i], max);
				}
			}
		}
		System.out.println(max);
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = num; i >= 1; i--) {
			if (max == dp[i]) {
				stack.push(arr[i]);
				max--;
			}
		}
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
	}

}
