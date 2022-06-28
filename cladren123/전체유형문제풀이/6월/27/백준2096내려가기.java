package studyGroup.June.june27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준2096내려가기 {

    static int n; // 줄의 갯수
    static StringTokenizer st;

    static int[][] board;
    static int[][] dpmax;
    static int[][] dpmin;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][3];
        dpmax = new int[n][3];
        dpmin = new int[n][3];

        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++)
        {
            dpmax[0][i] = board[0][i];
            dpmin[0][i] = board[0][i];
        }


        for(int i = 1; i < n; i++)
        {

            for(int j = 0; j < 3; j++)
            {


                if(j == 0)
                {
                    dpmax[i][j] = Math.max(dpmax[i-1][j], dpmax[i-1][j+1]) + board[i][j];
                    dpmin[i][j] = Math.min(dpmin[i-1][j], dpmin[i-1][j+1]) + board[i][j];
                }
                else if(j == 1)
                {
                    dpmax[i][j] = Math.max(dpmax[i-1][j-1], Math.max(dpmax[i-1][j], dpmax[i-1][j+1])) + board[i][j];
                    dpmin[i][j] = Math.min(dpmin[i-1][j-1], Math.min(dpmin[i-1][j], dpmin[i-1][j+1])) + board[i][j];
                }
                else
                {
                    dpmax[i][j] = Math.max(dpmax[i-1][j-1], dpmax[i-1][j]) + board[i][j];
                    dpmin[i][j] = Math.min(dpmin[i-1][j-1], dpmin[i-1][j]) + board[i][j];
                }


            }


        }

        int answermax = 0;
        int answermin = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++)
        {
            answermax = Math.max(answermax, dpmax[n-1][i]);
            answermin = Math.min(answermin, dpmin[n-1][i]);
        }

        System.out.println(answermax + " " + answermin);

    }

}
