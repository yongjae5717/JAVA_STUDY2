package studyGroup.June.june2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준1516게임개발 {

    static int n; // 갯수
    static int[] timeBoard;
    static int[] indegree;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> board;
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        timeBoard = new int[n+1];
        indegree = new int[n+1];
        dp = new int[n+1];
        board = new ArrayList<>();

        for(int i = 0; i < n+1; i++)
        {
            board.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++)
        {
            String str = br.readLine();
            String[] strlist = str.split(" ");

            timeBoard[i] = Integer.parseInt(strlist[0]);

            for(int j = 1; j < strlist.length; j++)
            {
                if(strlist[j].equals("-1")) continue;

                indegree[i]++;

                int one = Integer.parseInt(strlist[j]);
                board.get(one).add(i);
            }
        }

        que = new LinkedList<>();

        for(int i = 1; i <= n; i++)
        {
            dp[i] = timeBoard[i];

            if(indegree[i] == 0)
                que.add(i);
        }

        while (!que.isEmpty())
        {
            Integer now = que.poll();

            for(int next : board.get(now))
            {
                indegree[next]--;

                dp[next] = Math.max(dp[next], dp[now] + timeBoard[next]);

                if(indegree[next] == 0)
                {
                    que.add(next);
                }
            }
        }

        for(int i = 1; i <= n; i++)
        {
            System.out.println(dp[i]);
        }



    }

}
