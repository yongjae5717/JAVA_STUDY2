package studyGroup.June.june26;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*

https://sangbeomkim.tistory.com/84

 */



public class 백준17404번RGB거리2 {

    static int n; // 집의 개수
    static int[][] board; // 페인트 칠 비용
    static StringTokenizer st;
    static int[][] dp;
    static int[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        board = new int[n+1][3];
        dp = new int[n+1][3];
        result = new int[3];

        for(int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }




        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(i == j)
                {
                    dp[1][j] = board[1][j];
                }
                else
                {
                    dp[1][j] = 10001;
                }
            }

            for(int k = 2; k <= n; k++)
            {
                dp[k][0] = Math.min(dp[k-1][1], dp[k-1][2]) + board[k][0];
                dp[k][1] = Math.min(dp[k-1][0], dp[k-1][2]) + board[k][1];
                dp[k][2] = Math.min(dp[k-1][0], dp[k-1][1]) + board[k][2];

                if(k==n)
                {
                    if(i == 0)
                    {
                        result[i] = Math.min(dp[n][1], dp[n][2]);
                    }
                    if(i == 1)
                    {
                        result[i] = Math.min(dp[n][0], dp[n][2]);
                    }
                    if(i == 2)
                    {
                        result[i] = Math.min(dp[n][0], dp[n][1]);
                    }
                }
            }
        }


        System.out.println(Math.min(result[0], Math.min(result[1], result[2])));



    }

}
