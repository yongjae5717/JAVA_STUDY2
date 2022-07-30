import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] cluster, visit;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R+1][C];
        cluster = new boolean[R+1][C];
        visit = new boolean[R+1][C];

        for(int r = 1; r <= R; r++){
            String str = br.readLine();
            for(int c = 0; c < C; c++){
                map[r][c] = str.charAt(c);
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int turn = 0; turn < N; turn++){
            int k = Integer.parseInt(st.nextToken());
            destroy(k, turn);
            if(countCluster() != countMineral()){
                int distance = calculateFallDistance();
                fall(distance);
            }
        }
        print();
    }
    public static void fall(int distance){
        for(int r = R-1; r >= 1; r--){
            for(int c = 0; c < C; c++){
                // 클러스터가 아니지만 미네랄이라면
                if(!cluster[r][c] && map[r][c] == 'x'){
                    map[r][c] = '.';
                    map[r+distance][c] = 'x';
                }
            }
        }
    }

    public static int calculateFallDistance(){
        int min_dist = 1000;
        for(int c = 0; c < C; c++){
            for(int r = R-1; r >= 1; r--){
                if(map[r][c] == 'x' && !cluster[r][c]){
                    int dist = 1;
                    while(r+dist <= R && map[r+dist][c] == '.'){
                        dist++;
                    }
                    dist--;
                    min_dist = Math.min(min_dist, dist);
                    break;
                }
            }
        }
        if(min_dist == 1000){
            return 0;
        }
        else{
            return min_dist;
        }
    }

    public static int countCluster(){

        // 클러스터, 방문 배열 초기화
        cluster = new boolean[R+1][C];
        visit = new boolean[R+1][C];
        int numCluster = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int c = 0; c < C; c++){
            if(map[R][c] == 'x'){
                numCluster++;
                cluster[R][c] = true;
                visit[R][c] = true;
                queue.add(new int[] {R, c});
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i = 0; i < 4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                // 좌표를 벗어난 점이거나, 미네랄이 아니거나, 이미 방문한 경우
                if(ny < 1 || ny > R || nx < 0 || nx >= C || map[ny][nx] == '.' || visit[ny][nx])
                    continue;

                // 클러스터 발견
                numCluster++;
                cluster[ny][nx] = true;
                visit[ny][nx] = true;
                queue.add(new int[] {ny, nx});

            }
        }
        return numCluster;
    }

    public static int countMineral(){
        int numMineral = 0;
        for(int r = 1; r <= R; r++){
            for(int c = 0; c < C; c++){
                if(map[r][c] == 'x'){
                    numMineral++;
                }
            }
        }
        return numMineral;
    }

    public static void destroy(int k, int turn){
        if(turn % 2 == 0){
            for(int c = 0; c < C; c++){
                if(map[R-k+1][c] == 'x'){
                    map[R-k+1][c] = '.';
                    return;
                }
            }
        }
        else{
            for(int c = C - 1; c >= 0; c--){
                if(map[R-k+1][c] == 'x'){
                    map[R-k+1][c] = '.';
                    return;
                }
            }
        }
    }

    public static void print(){
        for(int r = 1; r <= R; r++){
            for(int c = 0; c < C; c++){
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
}