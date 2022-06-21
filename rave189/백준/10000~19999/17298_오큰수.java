package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(stk.nextToken());
		int[] result = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= arr[i])
				st.pop();
			result[i] = st.isEmpty() ? -1 : st.peek();
			st.add(arr[i]);
		}
		for (int v : result)
			answer.append(v).append(' ');
		System.out.println(answer);
	}
}