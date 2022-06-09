package studyGroup.June.june9;

import java.util.*;
import java.io.*;

public class 백준11054가장긴바이토닉부분수열 {

    static int n;
    static int[] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            board[i] = Integer.parseInt(st.nextToken());
        }


        if(n == 1)
        {
            System.out.println(1);
            return;
        }


        int answer = 0;
        for(int i = 0; i < n; i++)
        {
            answer = Math.max(answer, calc(i));
        }

        System.out.println(answer);

    }

    // 앞단에 오름차순 부분수열 중 가장 긴 값을 구하는 함수
    public static int calc(int index)
    {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 0;


        for(int i = 0; i <= index; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(board[i] > board[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = index; i < n; i++)
        {
            for(int j = index; j < i; j++)
            {
                if(board[i] < board[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            result = Math.max(result, dp[i]);
        }

        return result;

    }
}
