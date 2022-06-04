import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int max = Integer.MIN_VALUE; 
    static int min = Integer.MAX_VALUE;
    static char[][] graph;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                graph[i][j] = st.nextToken().charAt(0);
            }
        }
    }

    static void dfs(int x, int y, int sum, char oper) {
        // isNumber
        if (graph[x][y] >= '0' && graph[x][y] <= '5') {
            int num = graph[x][y] - '0';
            if (oper=='+') {
                sum+=num;
            } else if (oper=='-') {
                sum-=num;
            } else {
                sum*=num;
            }
        // Operator
        } else {
            oper = graph[x][y];
        }

        // Base Case
        if (x == N-1 && y == N-1) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        for (int i=0; i< 2; i++) {
            int nx = x+dx[i], ny = y+dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            dfs(nx, ny, sum, oper);
        }
        
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(0, 0, 0, '+');
        System.out.println(max + " " + min);
    }
}