package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder answer = new StringBuilder();
	static int[][] dp;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		dp = new int[n][2];
		int maxIdx = -1;
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && dp[j][0] + 1 > dp[i][0]) {
					dp[i][0] = dp[j][0] + 1;
					dp[i][1] = j;
				}
			if (dp[i][0] > maxLength) {
				maxLength = dp[i][0];
				maxIdx = i;
			}
		}
		makeAnswer(maxIdx);
		System.out.println(maxLength);
		System.out.println(answer);
	}

	public static void makeAnswer(int cur) {
		if (dp[cur][0] > 1)
			makeAnswer(dp[cur][1]);
		answer.append(arr[cur]).append(' ');
	}
}