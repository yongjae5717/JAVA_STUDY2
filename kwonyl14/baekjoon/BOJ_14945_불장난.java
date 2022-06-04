package day2206.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14945_불장난 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N + 1][N + 1];
        dp[2][1] = 2;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i-1; j++) {
                dp[i][j] = (dp[i-1][j]*2 + dp[i-1][j-1] + dp[i-1][j+1]) % 10007;
            }
        }
        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum & 10007);
    }
}
