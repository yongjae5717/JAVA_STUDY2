import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer;
    static ArrayList<int[]> startList;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        startList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 2){
                    startList.add(new int[] {j, i});
                }
            }
        }

        answer = 0;
        dfs(0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int num) {

        if(num == 3){
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(num+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){

        int[][] map2 = new int[N][M];
        for(int i = 0; i < N; i++){ //
            System.arraycopy(map[i], 0, map2[i], 0, M);
        }

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < startList.size(); i++){
            queue.add(startList.get(i));
        }

        while(!queue.isEmpty()){

            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx] || map2[ny][nx] != 0)
                    continue;

                queue.add(new int[] {nx, ny});
                visited[ny][nx] = true;
                map2[ny][nx] = 2;
            }
        }
        answer = Math.max(answer, countNum(map2));
    }
    public static int countNum(int[][] map){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void print(int[][] map){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}



