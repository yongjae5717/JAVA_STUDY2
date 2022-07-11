import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[][] memo;
    static boolean isInfinite;
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];
        memo = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String numbers = br.readLine();
            for (int j = 0; j < m; j++) {
                if (numbers.charAt(j) == 'H') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = numbers.charAt(j) - '0';
                }
            }
        }
        
        int ans = dfs(0, 0); // dfs와 dp를 통해 최대로 이동할 수 있는 횟수를 구한다
        if (isInfinite) { // 무한 반복이 가능한 경우에는 -1을 출력한다
            ans = -1;
        }
        System.out.print(ans);
    }
    
    private static int dfs(int x, int y) {
        if (isInfinite) {
            return -1;
        }
        if (x >= n || x < 0 || y >= m || y < 0) { // 동전이 보드의 바깥으로 나갈 경우
            return 0;
        }
        if (board[x][y] == 0) { // 동전이 구멍에 빠질 경우
            return 0;
        }
        if (visited[x][y]) { // 이미 방문한 위치에 동전이 다시 방문할 경우(== 무한 반복 가능한 경우)
            isInfinite = true;
            return -1;
        }
        if (memo[x][y] > 0) { // 이미 횟수가 메모된 위치라면 그 횟수를 리턴
            return memo[x][y];
        }
        
        visited[x][y] = true;
        memo[x][y] = Math.max(memo[x][y], dfs(x + board[x][y], y) + 1); // 오른쪽으로 이동
        memo[x][y] = Math.max(memo[x][y], dfs(x - board[x][y], y) + 1); // 왼쪽으로 이동
        memo[x][y] = Math.max(memo[x][y], dfs(x, y + board[x][y]) + 1); // 아래쪽으로 이동
        memo[x][y] = Math.max(memo[x][y], dfs(x, y - board[x][y]) + 1); // 위쪽으로 이동
        visited[x][y] = false;
        
        return memo[x][y];
    }
}