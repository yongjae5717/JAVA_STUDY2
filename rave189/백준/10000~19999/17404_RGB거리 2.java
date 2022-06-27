package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 집이 있다.
 * 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어진다.
 * 각 집을 원형으로 연결되어 있다 생각했을때, i번째 집은 i-1번째 집, i+1번째 집과 같은 색을 고르면 안된다.
 * 각 집을 칠하는 최소 비용을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	static final int COLOR_CNT = 3, RED = 0, GREEN = 1, BLUE = 2;
	static int[][] cost, dp;

	/**
	 * 첫 색깔을 결정해두고 시작
	 * 마지막 집을 어떻게 해야될지 몰라서 하드코딩으로 넣어둠
	 * 그냥 for문 돌려서 끝낼 수 있음.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		cost = new int[n][COLOR_CNT];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < cost[i].length; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < COLOR_CNT; i++) {
			dp = new int[n][COLOR_CNT];
			for (int j = 0; j < COLOR_CNT; j++)
				if (i == j)
					dp[0][j] = cost[0][j];
				else
					dp[0][j] = 1000000;
			for (int j = 1; j < n; j++) {
				dp[j][RED] = Math.min(dp[j - 1][GREEN], dp[j - 1][BLUE]) + cost[j][RED];
				dp[j][GREEN] = Math.min(dp[j - 1][RED], dp[j - 1][BLUE]) + cost[j][GREEN];
				dp[j][BLUE] = Math.min(dp[j - 1][RED], dp[j - 1][GREEN]) + cost[j][BLUE];
			}
			if (i == 0)
				answer = Math.min(answer, Math.min(dp[n - 1][GREEN], dp[n - 1][BLUE]));
			else if (i == 1)
				answer = Math.min(answer, Math.min(dp[n - 1][RED], dp[n - 1][BLUE]));
			else
				answer = Math.min(answer, Math.min(dp[n - 1][RED], dp[n - 1][GREEN]));
		}
		System.out.println(answer);
	}
}