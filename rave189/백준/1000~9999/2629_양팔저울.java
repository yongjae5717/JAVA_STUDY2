package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] weights = new int[n];
		boolean[][] dp = new boolean[n][40001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			weights[i] = Integer.parseInt(st.nextToken());
		dp[0][weights[0]] = true;
		for (int i = 1; i < dp.length; i++) {
			dp[i][weights[i]] = true;
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] |= dp[i - 1][j];
				if (dp[i - 1][Math.abs(j - weights[i])])
					dp[i][j] = true;
				if (j + weights[i] < dp[i].length && dp[i - 1][j + weights[i]])
					dp[i][j] = true;
			}
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (m-- > 0)
			answer.append(dp[n - 1][Integer.parseInt(st.nextToken())] ? 'Y' : 'N').append(' ');
		System.out.println(answer);
	}
}