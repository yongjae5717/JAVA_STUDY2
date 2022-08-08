import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int answer = 1;
        map = new char[N][M];
        for(int i=0; i< N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i< N; i++){
            for(int j=0; j<M; j++){
                visited = new boolean[N][M];
                answer = Integer.max(answer,bfs(i,j));
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int i, int j) {
        if (map[i][j]=='W') return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j,0});
        int max = 0;
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            int cnt = pos[2];
            max = Integer.max(max,cnt);
            for(int k=0; k<4; k++){
                int posY = r + dy[k];
                int posX = c + dx[k];
                if(posY<0||posY>=N||posX<0||posX>=M||visited[posY][posX]||map[posY][posX]=='W') continue;
                visited[posY][posX] = true;
                q.offer(new int[]{posY,posX,cnt+1});
            }
        }
        return max;
    }
}