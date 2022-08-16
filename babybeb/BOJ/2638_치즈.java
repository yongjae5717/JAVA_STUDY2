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

    static int n, m, ans;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        
        // 입력, 초기화
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cheese = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while (true) {
            
            // 1. 남은 치즈가 있는지 확인하기
            if (!existedCheese()) {
                break;
            }
            
            // 2. BFS로 치즈 내외부 구분하기
            visited = new boolean[n][m];
            bfs();
            
            // 3. 치즈 녹이기
            meltCheese();
            ans++;
        }
    
        System.out.print(ans);
    }
        
    
    private static void bfs() {
        
        Deque<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(0, 0));
        visited[0][0] = true;
    
        while (!queue.isEmpty()) {
            Coordinate curPos = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                Coordinate nextPos = new Coordinate(curPos.row + dy[i], curPos.col + dx[i]);
                
                if (nextPos.col < 0 || nextPos.row < 0 || nextPos.col >= m || nextPos.row >= n) {
                    continue;
                }
                if (visited[nextPos.row][nextPos.col]) {
                    continue;
                }
                if (cheese[nextPos.row][nextPos.col] == 1) { // 치즈인 경우
                    continue;
                }
                
                queue.add(nextPos);
                visited[nextPos.row][nextPos.col] = true;
                cheese[nextPos.row][nextPos.col] = -1;
            }
        }
    }
    
    private static void meltCheese() {
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheese[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextI = i + dx[k];
                        int nextJ = j + dy[k];
                        if (nextI < 0 || nextJ < 0 || nextJ >= m || nextI >= n) {
                            continue;
                        }
                        if (cheese[nextI][nextJ] == -1) {
                            cnt++;
                        }
                    }
                    if (cnt >= 2) {
                        cheese[i][j] = 2;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheese[i][j] == 2) {
                    cheese[i][j] = -1;
                }
            }
        }        
    }
    
    private static boolean existedCheese() {
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cheese[i][j] == 1) {
                    return true;
                }
            }
        }
        
        return flag;
    }
}