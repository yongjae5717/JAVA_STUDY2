import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static int n, m;
    static int startRow, startCol; // 탐색을 시작하는 좌표
    static boolean isCycled;
    static char[][] board;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        
        // dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && !isCycled) {
                    startRow = i;
                    startCol = j;
                    dfs(i, j, 1);
                }
            }
        }
        
        if (isCycled) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
    
    private static void dfs(int row, int col, int cnt) {
        
        visited[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            
            if (x >= 0 && y >= 0 && x < n && y < m && board[row][col] == board[x][y]
                && !visited[x][y]) {
                dfs(x, y, cnt + 1);
            }
            if (cnt >= 4 && x == startRow && y == startCol) {
                isCycled = true;
            }
        }
        visited[row][col] = false;
    }
}