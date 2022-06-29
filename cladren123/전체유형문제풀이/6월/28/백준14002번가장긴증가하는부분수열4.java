package studyGroup.June.june28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준14002번가장긴증가하는부분수열4 {

    static int n;
    static int[] board;
    static dot[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            board[i] = Integer.parseInt(st.nextToken());
        }

        dp = new dot[n];
        for(int i = 0; i < n; i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(board[i]);
            dp[i] = new dot(1, temp);
        }



        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(board[i] > board[j])
                {
                    if(dp[i].num < dp[j].num + 1)
                    {
                        ArrayList<Integer> t = new ArrayList<>(dp[j].arr);
                        t.add(board[i]);
                        dp[i] = new dot(dp[j].num + 1, t);
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++)
        {
            answer = Math.max(answer, dp[i].num);
        }

        for(int i = 0; i < n; i++)
        {
            if(dp[i].num == answer)
            {
                System.out.println(answer);
                for (Integer integer : dp[i].arr) {
                    System.out.print(integer + " ");
                }

                break;
            }
        }

    }

    public static class dot
    {
        int num;
        ArrayList<Integer> arr;

        dot(int num, ArrayList<Integer> arr)
        {
            this.num = num;
            this.arr = arr;
        }
    }

}
