import java.util.*;
import java.io.*;

class Main {
    static int INF = 100_000_000;
    static int N, M;
    static int[][] graph;
    static int[][] result;
    static StringBuilder sb;

    static class Edge {
        int to, len;

        Edge(int to, int len) {
            this.to=to;
            this.len=len;
        }

        public String toString() {
            return "(" + to + "," + len + ")";
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
      
        graph = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i!=j) {
                    graph[i][j] = INF;
                }
            }
        }

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            graph[from][to] = len;
            graph[to][from] = len;
        }

        result = new int[N+1][N+1];
        for (int i=1; i <= N; i++) {
            for (int j=1; j <= N; j++) {
                if (i == j) {
                    result[i][j]=0;
                } else {
                    result[i][j]=j;                
                }
            }
        }
    }

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        result[i][j] = result[i][k];
                    }
                }
            }
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();
        floyd();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (result[i][j] == 0) {
                    sb.append("- ");
                } else {
                    int t = j;
                    sb.append(result[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}