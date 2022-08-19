import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // map 입력받기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장자리 외부공기 처리
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(i == 0 || i == N - 1 || j == 0 || j == M - 1){
                    map[i][j] = 2;
                }
            }
        }

        // BFS 메소드 실행
        System.out.println(BFS());
    }

    public static int BFS(){
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        // 외부공기 흐름
        airSpread();

        // C치즈 큐에 삽입
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && isC(i, j)){
                    queue.add(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()){

            time++;
            // C치즈 제거
            while(!queue.isEmpty()){
                int[] t = queue.poll();
                map[t[0]][t[1]] = 0;
            }

            // 외부공기 흐름
            airSpread();

            // C치즈 큐에 삽입
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && isC(i, j)){
                        queue.add(new int[] {i, j});
                    }
                }
            }
        }
        return time;
    }

    public static boolean isC(int cy, int cx){
        int count = 0;

        for(int i = 0; i < 4; i++){
            int ny = cy + dy[i];
            int nx = cx + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M){
                continue;
            }
            if(map[ny][nx] == 2){
                count++;
            }
        }
        return (count >= 2)? true : false;
    }

    public static void airSpread(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2){
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0 && !visited[ny][nx]){
                    map[ny][nx] = 2;
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                }
            }
        }
    }

    public static void print(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}





