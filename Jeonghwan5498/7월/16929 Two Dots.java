import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean isCycleExist;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char[N][M];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        isCycleExist = false;
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-1; j++){
                visited[i][j] = true;
                CycleSearch(j, i, j, i, 1);
                if(isCycleExist){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    public static void CycleSearch(int x, int y, int tx, int ty, int depth){

        if(isCycleExist) return;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= ny && ny < N && 0 <= nx && nx < M){

                if(nx == tx && ny == ty && depth >= 4){
                    isCycleExist = true;
                    return;
                }

                if(!visited[ny][nx] && map[y][x] == map[ny][nx]) {
                    visited[ny][nx] = true;
                    CycleSearch(nx, ny, tx, ty, depth+1);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}