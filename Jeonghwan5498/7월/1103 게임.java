import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static char[][] map;
    static int[][] DP;
    static int[] dy = {0,  0, 1, -1};
    static int[] dx = {1, -1, 0,  0};
    static boolean[][] visited;
    static boolean Is_infinite;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 보드배열(map) 초기화
        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        // DP배열 초기화, 방문배열 초기화
        visited = new boolean[N][M];
        DP = new int[N][M];

        // DFS 실행
        answer = 1;
        visited[0][0] = true;
        Is_infinite = false;
        DFS(0,0, 1);

        if(Is_infinite) answer = -1;
        System.out.println(answer);

    }

    public static void DFS(int cy, int cx, int depth){

        if(Is_infinite)
            return;

        answer = Math.max(answer, depth);
        DP[cy][cx] = depth;

        for(int i = 0; i < 4; i++){
            int step = map[cy][cx] - '0';
            int ny = cy + (step * dy[i]);
            int nx = cx + (step * dx[i]);

            // 다음 포인트가 배열 안에 있다면
            if(0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] != 'H'){

                // 다음 포인트가 이미 방문한 포인트라면 무한 루프 발생
                if(visited[ny][nx]){
                    // System.out.println("check1 : " + next[0] + " " + next[1] + " value : " + -1);
                    Is_infinite = true;
                    answer = Integer.MAX_VALUE;
                    return;
                }

                // 다음 포인트가 처음 방문하는 포인트라면, 더 이상 탐색할 가치가 있다면
                if(DP[ny][nx] < depth + 1){
                    visited[ny][nx] = true;
                    DFS(ny, nx, depth + 1);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}
