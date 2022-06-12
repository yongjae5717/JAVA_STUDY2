import java.util.*;
import java.io.*;

class Main {

    static int N, sx, sy;
    static char[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Mirror implements Comparable<Mirror> {
        int x;
        int y;
        int cnt;
        int dir;

        Mirror(int x, int y, int cnt, int dir) {
            this.x=x;
            this.y=y;
            this.cnt=cnt;
            this.dir=dir;
        }

        @Override
        public int compareTo(Mirror m) {
            return this.cnt - m.cnt;
        }
    }
  
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i=0; i < N; i++) {
            String row = br.readLine();
            for (int j=0; j < N; j++) {
                graph[i][j] = row.charAt(j);
  
                if (graph[i][j] == '#') {
                    sx=i; 
                    sy=j;
                }
            }
        }
    }

    static void bfs(int stx, int sty) {
        PriorityQueue<Mirror> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[N][N][4];
        for (int i=0; i< 4; i++) {
            pq.offer(new Mirror(stx, sty, 0, i));
        }

        while (!pq.isEmpty()) {
            Mirror m = pq.poll();

            int x = m.x;
            int y = m.y;
            int cnt = m.cnt;
            int dir = m.dir;

            visited[x][y][dir]=true;

            // Base Case
            if (graph[x][y] == '#' && (x!=sx && y!=sy)) {
                System.out.println(cnt);
                return;
            }

            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if (graph[nx][ny] != '*' && !visited[nx][ny][dir]) {
                if (graph[nx][ny] == '!') {
                    // 시계방향 설치
                    int nDir = (dir + 3) % 4;
                    pq.offer(new Mirror(nx, ny, cnt+1, nDir));
                    // 반시계방향 설치
                    nDir = (dir + 1) % 4;
                    pq.offer(new Mirror(nx, ny, cnt+1, nDir));
                }
            }
            pq.offer(new Mirror(nx, ny, cnt, dir));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(sx, sy);
    }
}
