import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map, colorMap;
    static boolean[][] visited;
    static int[] answer;
    static int[] dx = {-1,1};
    static int[] dy = {-1,-1};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        colorMap = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                colorMap[i][j] = (i % 2 + j % 2) % 2;
            }
        }
        visited = new boolean[N][N];
        answer = new int[2];
        DFS(0,0, 0);
        DFS(0, 1, 0);
        System.out.println(answer[0] + answer[1]);
    }

    public static void DFS(int start, int color, int depth){

        for(int k = start; k < N*N; k++){

            int i = k / N;
            int j = k % N;

            if(map[i][j] == 0 || colorMap[i][j] != color || !check(j, i))
                continue;

            visited[i][j] = true;
            DFS(k+1, color, depth + 1);
            visited[i][j] = false;
        }
        answer[color] = Math.max(answer[color], depth);
    }

    public static boolean check(int x, int y){

        for(int i = 0; i < 2; i++){
            int nx = x;
            int ny = y;
            while(true){
                if(0 > nx || nx >= N || 0 > ny || ny >= N)
                    break;
                if(visited[ny][nx])
                    return false;
                nx += dx[i];
                ny += dy[i];

            }
        }
        return true;
    }
}

