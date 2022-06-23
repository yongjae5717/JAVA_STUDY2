package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3xN 크기의 벽을 2x1, 1x2로 채우는 경우의 수를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 다 풀어놓고 4개, 6개 .. 짜리 블록으로 만드는 경우를 뒤집어서 생각하는걸 추가 안해서 틀림
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 2; i <= n; i += 2) {
			dp[i] += dp[i - 2] * 3;
			for (int j = 4; j <= i; j += 2)
				dp[i] += dp[i - j] * 2;
		}
		System.out.println(dp[n]);
	}
}