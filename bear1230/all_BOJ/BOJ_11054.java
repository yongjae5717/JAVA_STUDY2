import java.io.*;
import java.util.*;

/**
 * 11054번 가장 긴 바이토닉 부분 수열
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][2];
		int[] map = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 1;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = dp[i][1] = 1;
			for (int j = 1; j < i; j++) {
				if (map[j] < map[i]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
				} else if (map[j] > map[i]) {
					dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][1] + 1, dp[j][0] + 1));
				}
			}
			ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
		}

		System.out.println(ans);
	}
}
