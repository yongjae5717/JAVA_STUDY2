// 답안확인

import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        dp = new int[N+1][N+1];
        dp[2][1]=2;

        for (int i=3; i <=N; i++) {
            for (int j=1; j < i; j++) {
                dp[i][j] = (dp[i-1][j]*2 + dp[i-1][j-1] + dp[i-1][j+1]) % 10007;
            }  
        }

        int result = 0;
        for (int i=1; i < N; i++) {
            result+=dp[N][i];
        }
        System.out.println(result);
    }
}