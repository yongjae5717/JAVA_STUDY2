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
    //    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
    static int m, n, answer = 0;
    static Queue<Coordinate> queue = new LinkedList<>();
    static char[][] map;
    static int[][] cnt;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        cnt = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    cnt[i][j] = 1;
                    queue.add(new Coordinate(i, j));
                    bfs();
                    resetArray();
                }
            }
        }
        
        System.out.print(answer);
    }
    
    private static void resetArray() {
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt[i][j] = 0;
            }
        }
    }
    
    private static void bfs() {
        while (!queue.isEmpty()) {
            Coordinate curPos = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Coordinate nextPos = new Coordinate(curPos.row + dy[i], curPos.col + dx[i]);
                
                if (nextPos.col < 0 || nextPos.row < 0 || nextPos.col >= m || nextPos.row >= n) {
                    continue;
                }
                if (map[nextPos.row][nextPos.col] == 'W') {
                    continue;
                }
                if (cnt[nextPos.row][nextPos.col] > 0) {
                    continue;
                }
                
                queue.add(nextPos);
                cnt[nextPos.row][nextPos.col] = cnt[curPos.row][curPos.col] + 1;
                if (cnt[nextPos.row][nextPos.col] - 1 > answer) {
                    answer = cnt[nextPos.row][nextPos.col] - 1;
                }
            }
        }
    }
}