package studyGroup.july.july25;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

조합 최적화의 문제
배당문제, 냅색 알고리즘



 */


public class 백준12865평범한배낭 {

    static int n, k;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n+1][2];

        for(int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[i][0] = w;
            board[i][1] = v;
        }

        // 가로 : 무게수   세로 : 물건의 목차
        dp = new int[n+1][k+1];

        // 무게가 기준이 되어 물건 탐색을 시작한다.

        int answer = 0;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= k; j++)
            {
                dp[i][j] = dp[i-1][j];

                // 여분이 있다면
                if(j - board[i][0] >= 0)
                {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - board[i][0]] + board[i][1]);
                }

                answer = Math.max(answer, dp[i][j]);
            }
        }


        System.out.println(answer);


    }

}
