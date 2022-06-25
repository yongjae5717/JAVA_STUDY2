package day2206.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133_타일채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }
        if (N == 2) {
            System.out.println(3);
            return;
        }

        int dp[] = new int[N + 1];
        dp[0] = 1;
        dp[2] = 3;
        int sum = 0;
        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i-2] * dp[2];
            for (int j = 0; j <= i - 4; j += 2) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[N]);
    }
}
