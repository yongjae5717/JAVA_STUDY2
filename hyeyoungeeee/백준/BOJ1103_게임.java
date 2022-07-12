package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1103_게임 {
    static int N, M;
    static int[][] Map;
    static int[][] dp;
    static boolean[][] Visited;
    static int Max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean isLoop = false;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BOJ1103_게임/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[N][M];
        dp = new int[N][M];
        Visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if(line.charAt(j) == 'H'){
                    Map[i][j] = -1;
                }else {
                    Map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }
        }
        Visited[0][0] = true;
        dfs(0, 0, 1);

        if(isLoop) {
            System.out.println(-1);
        } else {
            System.out.println(Max);
        }
    }
    static void dfs(int x, int y, int step){
        Max = Math.max(Max, step);
        dp[x][y] = step;

        for (int i = 0; i < 4; i++) {
            int move = Map[x][y];
            int nx = x + dx[i] * move;
            int ny = y + dy[i] * move;

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || Map[nx][ny] == -1) continue;
            if(Visited[nx][ny]) {
                isLoop = true;
                return;
            }

            if(dp[nx][ny] > step) continue;

            Visited[nx][ny] = true;
            dfs(nx, ny, step + 1);
            Visited[nx][ny] = false;
        }
    }
}

