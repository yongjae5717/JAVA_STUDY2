import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair {
        
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int t;
    static int l, desX, desY;
    static boolean[][] visited;
    static int[] dx, dy;
    
    static int[][] cnt;
    
    public static void main(String[] args) throws IOException {
        
        dx = new int[]{-2, -1, -2, -1, 2, 1, 2, 1};
        dy = new int[]{-1, -2, 1, 2, -1, -2, 1, 2};
        
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            desX = Integer.parseInt(st.nextToken());
            desY = Integer.parseInt(st.nextToken());
            visited = new boolean[l][l];
            cnt = new int[l][l];
            bfs(x, y);
            sb.append(cnt[desX][desY] + "\n");
        }
        System.out.print(sb.toString());
    }
    
    private static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Pair(x, y));
        while (!queue.isEmpty()) {
            Pair curPos = new Pair(queue.peek().x, queue.poll().y);
            
            if (curPos.x == desX && curPos.y == desY) {
                return;
            }
            
            for (int i = 0; i < 8; i++) {
                int nextX = curPos.x + dx[i];
                int nextY = curPos.y + dy[i];
                
                if (nextX < 0 || nextX >= l || nextY < 0 || nextY >= l) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                
                visited[nextX][nextY] = true;
                cnt[nextX][nextY] = cnt[curPos.x][curPos.y] + 1;
                queue.add(new Pair(nextX, nextY));
            }
        }
    }
}