import java.io.*;
import java.util.*;

public class Main {
    
    static class Coordinate {
        
        int row, col;
        
        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int m, n, answer = 0;
    static Queue<Coordinate> queue = new LinkedList<>();
    static int[][] storage;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        storage = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 처음부터 익어 있는 토마토는 큐에 넣고 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == 1) {
                    queue.add(new Coordinate(i, j));
                }
            }
        }
        
        bfs();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == 0) { // 익지 못한 토마토가 있을 때
                    System.out.println(-1);
                    return;
                }
                if (storage[i][j] > answer) {
                    answer = storage[i][j];
                }
            }
        }
        
        System.out.print(answer - 1);
    }
    
    /* 이미 익은 토마토부터 bfs 진행. 단, 이미 방문한 곳(storage >= 1)이나 토마토가 없는 곳(storage == -1)은 방문 안 함 */
    private static void bfs() {
        while (!queue.isEmpty()) {
            Coordinate curPos = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Coordinate nextPos = new Coordinate(curPos.row + dy[i], curPos.col + dx[i]);
                
                if (nextPos.col < 0 || nextPos.row < 0 || nextPos.col >= m || nextPos.row >= n) {
                    continue;
                }
                if (storage[nextPos.row][nextPos.col] != 0) {
                    continue;
                }
                
                queue.add(nextPos);
                storage[nextPos.row][nextPos.col] = storage[curPos.row][curPos.col] + 1;
            }
        }
    }
}