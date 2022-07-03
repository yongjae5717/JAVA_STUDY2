package studyGroup.july.july1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class 백준1005ACMCraft {

    static int t;
    static int n, k;
    static int[] build;
    static int[][] board1; // s -> e
    static int[][] board2; // e -> s
    static int[] count;
    static int[] visited;
    static int w;

    static BufferedReader br;
    static StringTokenizer st;

    static int time;

    static int[] answer;




    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        answer = new int[t];


        for(int i = 0; i < t; i++)
        {
            solution(i);
        }

        for (int i : answer) {
            System.out.println(i);
        }

    }


    public static void solution(int index) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        build = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++)
        {
            build[i] = Integer.parseInt(st.nextToken());
        }

        board1 = new int[n+1][n+1];
        board2 = new int[n+1][n+1];
        count = new int[n+1];
        visited = new int[n+1];
        for(int i = 0; i < k; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            board1[s][e] = 1;
            board2[e][s] = 1;
            count[e]++;
        }

        w = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= n; i++)
        {
            if(count[i] == 0)
            {
                visited[i] = 1;
                que.add(i);
            }
        }

        answer[index] = build[w];

        while(!que.isEmpty())
        {
            Integer p = que.poll();

            for(int i = 1; i <= n; i++)
            {
                if(board1[p][i] == 1)
                {
                    count[i]--;
                }
            }

            for(int i = 1; i <= n; i++)
            {
                if(count[i] == 0 && visited[i] == 0)
                {
                    que.add(i);
                    visited[i] = 1;

                    int best = 0;
                    for(int j = 1; j <= n; j++)
                    {
                        if(board2[i][j] == 1)
                        {
                            best = Math.max(best, build[j]);
                        }
                    }

                    build[i] = best + build[i];

                    if(i == w)
                    {

                        answer[index] = build[i];
                        return;
                    }

                }
            }






        }


    }




}
