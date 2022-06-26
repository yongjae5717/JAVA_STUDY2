package studyGroup.June.june25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://subbak2.tistory.com/52

public class 백준2458키순서 {

    static int n, m;
    static int[][] board;

    static final int inf = 999999; // Integer.MAX_VALUE 를 사용하면 이상한 값이 나온다.


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                board[i][j] = inf;
            }
        }


        // a -> b
        for(int i = 1; i <= m; i++)
        {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            board[s][e] = 1;
        }

        // 특정 학생이 모든 학생과의 거리를 체크해야하므로 플로이드 워셜 수행
        // 플로이드 - 워셜 : 경유지 - 출발지 - 도착지 3중 for문
        for(int k = 1; k <= n; k++)
        {
            for(int i = 1; i <= n; i++)
            {
                for(int j = 1; j <= n; j++)
                {
                    board[i][j] = board[i][j] <= board[i][k] + board[k][j] ? board[i][j] : board[i][k] + board[k][j];
                }
            }
        }



        int answer = 0;

        for(int i = 1; i <= n; i++)
        {
            int count = 0;
            for(int j = 1; j <= n; j++)
            {
                if(board[i][j] != inf || board[j][i] != inf) count++;
            }
            if(count == n-1) answer++;
        }

        System.out.println(answer);


    }






}
