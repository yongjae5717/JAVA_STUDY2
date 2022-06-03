package studyGroup.June.june3;

import java.util.*;
import java.io.*;

/*

중복되는 문제가 있기 때문에 DP로 접근한다.

이동할 수 있는 경우의 수는 4가지이다.
1. 둘 다 아래 (거리 그대로)
2. 1번 아래, 2번 오른쪽 (거리 +1)
3. 1번 오른쪽, 2번 오른쪽 (거리 그대로)
4. 1번 오른쪽, 2번 아래 (거리 -1)

DP[타일수][두 사람의 거리] = 안전하게 빠져나가는 경우의 수
DP[now][dist] = DP[now-1][dist] * 2 + DP[now-1][dist-1] + DP[now-1][]dist+1

https://kimcodingvv.github.io/BOJ-14945/

 */

public class 백준14945불장난 {

    static int n;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[105][105];

        dp[2][1] = 2;

        for(int i = 3; i <= n; i++)
        {
            for(int j = 1; j <= i-1; j++)
            {
                dp[i][j] = (dp[i-1][j] * 2 + dp[i-1][j-1] + dp[i-1][j+1]) % 10007;
            }
        }

        int sum = 0;
        for(int i = 1; i <= n; i++)
        {
            sum += dp[n][i];
        }

//        for(int i = 0; i <= n; i++)
//        {
//            for(int j = 0; j <= i; j++)
//            {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(sum % 10007);




    }

}
