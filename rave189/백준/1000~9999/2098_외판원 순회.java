package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, answer = Integer.MAX_VALUE;
	static int[][] cost, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];
		dp = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][1] = 0;
		dfs(1, 0);
		System.out.println(answer);
	}

	public static void dfs(int visited, int cur) {
		if (visited == (1 << n) - 1) {
			if (cost[cur][0] > 0)
				answer = Math.min(answer, dp[cur][visited] + cost[cur][0]);
			return;
		}
		for (int i = 0; i < n; i++) {
			int nextVisited = visited | (1 << i);
			if (visited == nextVisited || cost[cur][i] == 0)
				continue;
			if (dp[cur][visited] + cost[cur][i] < dp[i][nextVisited]) {
				dp[i][nextVisited] = dp[cur][visited] + cost[cur][i];
				dfs(visited + (1 << i), i);
			}
		}
	}
}