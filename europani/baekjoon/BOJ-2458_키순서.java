import java.util.*;
import java.io.*;

class Main {

    static int N, M, result;
    static boolean[][] graph;
    static int[] cnt;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        cnt = new int[N+1];

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b]=true;
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();

        for (int k=1; k <= N; k++) {
            for (int i=1; i <= N; i++) {
                for (int j=1; j <= N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        for (int i=1; i <= N; i++) {
            for (int j=1; j <= N; j++) {
                if (graph[i][j] || graph[j][i]) {
                    cnt[i]++;
                }
            }
        }

        for (int c : cnt) {
            if (c == N-1) {
                result++;
            }
        }
        System.out.println(result);
    }
}