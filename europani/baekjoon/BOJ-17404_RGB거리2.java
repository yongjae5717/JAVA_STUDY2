import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int INF = 1_000_001;
    static int[][] graph, dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][3];
        dp = new int[N][3];
      
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[i][0] = r;
            graph[i][1] = g;
            graph[i][2] = b;
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();
        int result = INF;
      
        for (int i=0; i<3; i++) {    // 시작줄 색깔 고정 (R,G,B)
            Arrays.fill(dp[0], INF);
            dp[0][i] = graph[0][i];
          
            for (int j=1; j < N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + graph[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + graph[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + graph[j][2];
            }

            for (int j=0; j < 3; j++) {
                if (j == i) continue;    // 시작줄과 같은 색 skip
                result = Math.min(dp[N-1][j], result);
            }
        }

        System.out.println(result);
    }
}