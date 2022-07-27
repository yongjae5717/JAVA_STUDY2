package studyGroup.july.july26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

앞뒤를 뒤집어도 똑같은게 팰린드롬
1트 : 시간초과

 */

public class 백준10942팰린드롬 {

    static int n;
    static int[] board;
    static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++)
        {
            board[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int answer = 0;
            if(palin(s, e)) {
                answer = 1;
            }

            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

    public static boolean palin(int start, int end)
    {
        int s = start;
        int e = end;

        while(s < e)
        {
            if(board[s] != board[e])
            {
                return false;
            }

            s++;
            e--;
        }

        return true;

    }

}
