package studyGroup.June.june10;

import java.util.*;
import java.io.*;
import java.lang.*;

/*
어디서 시작되는지는 모른다.
 */

public class 백준2098외판원순회 {

    static int n; // 도시의 수
    static int[][] board;
    static int[][] dp;
    static int INF = 11000000;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][(1 << n) - 1];


        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(tsp(0,1));

    }

    static int tsp(int city, int visited)
    {
        if(visited == (1 << n) - 1)
        {
            if(board[city][0] == 0)
            {
                return INF;
            }
            return board[city][0]; // 현재 도시에서 시작 도시로 이동하는경우
        }

        if(dp[city][visited] != INF)
        {
            return dp[city][visited];
        }

        for(int i = 0; i < n; i++)
        {
            if((visited & (1 << i)) == 0 && board[city][i] != 0)
            {
                dp[city][visited] = Math.min(dp[city][visited], tsp(i, visited | (1 << i)) + board[city][i]);
            }
        }

        return dp[city][visited];

    }

    // visited & (1 << i) i 번째 해당 자리에 값을 구한다.
    // visited | (1 << i) i 번째 해당 자리에 1로 한다.




}
