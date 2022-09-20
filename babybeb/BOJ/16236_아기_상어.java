import java.io.*;
import java.util.*;

public class Main {
    
    
    static class Coordinate {
        
        int row, col;
        
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
        
        @Override
        public boolean equals(Object obj) {
            Coordinate o = (Coordinate) obj;
            
            if (this.row == o.row && this.col == o.col) {
                return true;
            }
            
            return false;
        }
    }
    
    static class PQInfo implements Comparable<PQInfo> {
        
        int distance;
        Coordinate coordinate;
        
        public PQInfo(int distance, Coordinate coordinate) {
            this.distance = distance;
            this.coordinate = coordinate;
        }
        
        @Override
        public int compareTo(PQInfo o) {
            if (this.distance == o.distance) {
                if (this.coordinate.row == o.coordinate.row) {
                    return this.coordinate.col - o.coordinate.col;
                }
                return this.coordinate.row - o.coordinate.row;
            }
            return this.distance - o.distance;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, max, size = 2, fishCnt; // 현재 크기에 도달한 이후 먹이를 먹은 횟수
    static int[][] space;
    static int[][] cnt;
    static boolean[][] visited;
    static int[][] dxy = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static Coordinate start, sharkLocation;
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        n = Integer.parseInt(br.readLine());
        space = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    start = new Coordinate(i, j);
                    sharkLocation = new Coordinate(i, j);
                    space[i][j] = 0;
                }
            }
        }
        
        while (true) {
            PQInfo location = bfs(start); // 상어가 마지막으로 먹은 물고기 위치
            if (location.distance < 0) { // 물고기를 먹지 못한 경우
                break; // 엄마 상어를 찾는다
            } else { // 마지막으로 물고기를 먹은 위치를 다음 bfs의 시작 위치로 정한다
                start = location.coordinate;
            }
        }
        
        System.out.print(max);
    }
    
    private static PQInfo bfs(Coordinate s) {
        cnt = new int[n][n];
        visited = new boolean[n][n];
        PriorityQueue<PQInfo> pq = new PriorityQueue<>();
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s.row][s.col] = true;
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate next = new Coordinate(cur.row + dxy[i][0], cur.col + dxy[i][1]);
                if (next.row < 0 || next.row >= n || next.col < 0 || next.col >= n) { // 좌표에서 벗어난 위치
                    continue;
                }
                if (space[next.row][next.col] > size) { // 아기 상어보다 큰 물고기가 있는 위치
                    continue;
                }
                if (visited[next.row][next.col]) { // 이번 bfs에서 이미 방문한 위치
                    continue;
                }
                if (space[next.row][next.col] != 0
                    && space[next.row][next.col] < size) { // 먹을 수 있는 물고기가 있는 위치
                    pq.add(
                        new PQInfo(cnt[cur.row][cur.col] + 1, next)); // 먹을 가능성이 있는 물고기를 우선순위 큐에 넣는다
                }
                queue.add(next);
                cnt[next.row][next.col] = cnt[cur.row][cur.col] + 1;
                visited[next.row][next.col] = true;
            }
        }
        
        if (pq.isEmpty()) { // 먹을 수 있는 물고기가 없는 경우
            return new PQInfo(-1, new Coordinate(0, 0));
        }
        
        // 최적 위치의 물고기를 먹는다
        space[pq.peek().coordinate.row][pq.peek().coordinate.col] = 0;
        fishCnt++;
        if (fishCnt == size) {
            size++;
            fishCnt = 0;
        }
        max += pq.peek().distance; // 과거에 물고기를 먹기 위해 이동한 거리 + 이번 물고기를 먹기 위해 이동한 거리
        return pq.poll();
    }
}