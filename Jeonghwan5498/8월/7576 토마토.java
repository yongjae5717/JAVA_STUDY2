import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    public static int bfs(){

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1){
                    // (x좌표, y좌표) 큐에 삽입
                    queue.add(new int[] {j, i});
                    visited[i][j] = true;
                }
            }
        }

        int time = -1;

        // 방문할 수 있는 곳 다 방문하기
        while(!queue.isEmpty()){
            time++;
            int S = queue.size();
            for(int s = 0; s < S; s++){

                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];

                for(int i = 0; i < 4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx < 0 || nx >= M || ny < 0 || ny >= N || map[ny][nx] == -1 || visited[ny][nx] )
                        continue;

                    visited[ny][nx] = true;
                    map[ny][nx] = 1;
                    queue.add(new int[] {nx, ny});

                }
            }
        }
        boolean zeroExist = false;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    zeroExist = true;
                }
            }
        }
        if(zeroExist)
            return -1;
        else
            return time;
    }
}
