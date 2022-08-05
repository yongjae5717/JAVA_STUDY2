import java.io.*;
import java.util.*;

public class Main {

    static int H, W;
    static char[][] map;
    static int max_dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        ArrayList<int[]> landList = new ArrayList<>();

        for(int i = 0; i < H; i++){
            String str = br.readLine();
            for(int j = 0; j < W; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'L'){
                    landList.add(new int[] {j, i});
                }
            }
        }

        max_dist = 0;
        for(int i = 0; i < landList.size(); i++){
            bfs(landList.get(i));
        }

        System.out.println(max_dist);
    }

    public static void bfs(int[] start){

        boolean[][] visited = new boolean[H][W];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[1]][start[0]] = true;

        int depth = -1;
        while(!queue.isEmpty()){

            depth++;
            int S = queue.size();

            for(int s = 0; s < S; s++){

                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];

                for(int i = 0; i < 4; i++){

                    int nx = dx[i] + cx;
                    int ny = dy[i] + cy;

                    if(nx < 0 || nx >= W || ny < 0 || ny >= H || map[ny][nx] == 'W' || visited[ny][nx])
                        continue;
                    visited[ny][nx] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        max_dist = Math.max(max_dist, depth);
    }
}