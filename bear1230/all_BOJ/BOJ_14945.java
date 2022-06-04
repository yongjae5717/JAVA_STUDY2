import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][N + 1];
		dp[2][1] = 2;

		for (int i = 3; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = (dp[i - 1][j] * 2 + dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 10007;
			}
		}

		int ans = 0;
		for (int i = 1; i < N; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans % 10007);
	}
}