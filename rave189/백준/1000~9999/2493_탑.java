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
		int[] tower = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			tower[i] = Integer.parseInt(stk.nextToken());
		Stack<Integer> st = new Stack<>();
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && tower[st.peek()] < tower[i])
				st.pop();
			count[i] = st.isEmpty() ? 0 : st.peek() + 1;
			st.add(i);
		}
		for (int v : count)
			answer.append(v).append(' ');
		System.out.println(answer);
	}
}