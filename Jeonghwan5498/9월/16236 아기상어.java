import java.io.*;
import java.util.*;

public class Main {

    public static class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o){
            if(dist == o.dist){
                if(x == o.x){
                    return y - o.y;
                }
                else{
                    return x - o.x;
                }
            }
            else{
                return dist - o.dist;
            }
        }
    }

    static int N;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    q.add(new Point(i, j,0));
                    map[i][j] = 0;
                }
            }
        }

        int eat = 0;
        int size = 2;
        int ans = 0;

        while(true){
            PriorityQueue<Point> pq = new PriorityQueue<>();
            int[][] dist = new int[N][N];

            // 다음 먹이까지의 거리 찾기
            while (!q.isEmpty()) {
                // 현재 지점

                Point cur = q.poll();

                for(int i = 0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || dist[nx][ny] != 0 || map[nx][ny] > size){
                        continue;
                    }

                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    q.add(new Point(nx, ny, dist[nx][ny]));

                    if(map[nx][ny] > 0 && map[nx][ny] != size){
                        pq.add(new Point(nx, ny, dist[nx][ny]));
                    }
                }
            }

            // 먹이가 더이상 없다면 엄마상어한테 가기 (while문 탈출)
            if(pq.isEmpty()){
                break;
            }

            // 먹이가 있다면 가장 앞선 순서의 먹이 고르기
            Point curFish = pq.poll();
            ans += curFish.dist;
            eat++;
            map[curFish.x][curFish.y] = 0;

            if(eat == size) {
                size++;
                eat = 0;
            }

            // 먹이를 먹은 장소에서 다시 출발하기
            q.add(new Point(curFish.x, curFish.y, 0));
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}



