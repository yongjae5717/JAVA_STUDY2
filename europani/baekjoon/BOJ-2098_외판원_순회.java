import java.util.*;
import java.io.*;

class Main {
  
    static int INF = 1_000_000_000;
    static int N;
    static int[][] cost, dp;

    static void input() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      cost = new int[N][N];
      dp = new int[N][1<<N];

      for (int i=0; i < N; i++) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          for (int j=0; j < N; j++) {
              cost[i][j] = Integer.parseInt(st.nextToken());
          }
      }

      for (int i=0; i < N; i++) {
          Arrays.fill(dp[i], INF);
      }
    }

    static int TSP(int now, int visit) {
        // 이미 계산한 경우
        if (dp[now][visit] != INF) {
            return dp[now][visit];
        }

        // 모든 지점을 방문한 경우
        if (visit == (1<<N)-1) {
            if (cost[now][0] == 0) {
                return INF;
            }
            return cost[now][0];
        }

        for (int i = 0; i < N; i++) {
            int next = visit | (1<<i);

            if ((visit & (1<<i)) != 0) continue;    // 이미 방문한 경우
            if (cost[now][i] == 0) continue;    // 길이 없는 경우

            dp[now][visit] = Math.min(TSP(i, next) + cost[now][i], dp[now][visit]);
        }

        return dp[now][visit];
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(TSP(0, 1));
    }
}
