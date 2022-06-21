package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * N개의 원소를 가진 수열 A가 주어진다.
 * Ai의 오등큰수를 구하는 문제
 * 오등큰수란 Ai보다 오른쪽에 있으면서 수열 A에서 Ai보다 더 많이 등장한 수를 의미한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 오큰수에서 횟수만 추가하면 되는 문제
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[1000001];
		int[] arr = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			count[arr[i]]++;
		}
		Stack<Integer> st = new Stack<>();
		int[] result = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && count[st.peek()] <= count[arr[i]])
				st.pop();
			result[i] = st.isEmpty() ? -1 : st.peek();
			st.add(arr[i]);
		}
		for (int v : result)
			answer.append(v).append(' ');
		System.out.println(answer);
	}
}