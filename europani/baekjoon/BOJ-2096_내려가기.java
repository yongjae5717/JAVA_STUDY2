import java.util.*;
import java.io.*;

class Main {

    static int INF = 1_000_001;
    static int N, maxi, mini = INF;
    static int[][] graph, dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][3];
      
        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[i][0] = a;
            graph[i][1] = b;
            graph[i][2] = c;
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();

        dp = new int[N][3];
        for (int i=0; i < 3; i++) {
            dp[0][i] = graph[0][i];
        }
      
        for (int i=1; i < N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + graph[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + graph[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + graph[i][2];
        }

        for (int x : dp[N-1]) {
            maxi = Math.max(x, maxi);
        }

        dp = new int[N][3];
        for (int i=0; i < 3; i++) {
            dp[0][i] = graph[0][i];
        }

        for (int i=1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + graph[i][0];
            dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + graph[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + graph[i][2];
        }

        for (int x : dp[N-1]) {
            mini = Math.min(x, mini);
        }

        System.out.println(maxi + " " + mini);
    }
}