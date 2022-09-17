import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, k;
    static boolean[] visited;
    static int[] cnt;
    static int[] dx = new int[]{1, -1};
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        visited = new boolean[100001];
        cnt = new int[100001];
        bfs();
        
        System.out.print(cnt[k]);
    }
    
    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[n] = true;
        queue.add(n);
        while (!queue.isEmpty()) {
            int curPos = queue.poll();
            if (curPos == k) {
                return;
            }
            
            for (int i = 0; i < 2; i++) { // +1, -1하는 경우
                int nextPos = curPos + dx[i];
                if (nextPos > 100000 || nextPos < 0) {
                    continue;
                }
                if (visited[nextPos]) {
                    continue;
                }
                
                visited[nextPos] = true;
                cnt[nextPos] = cnt[curPos] + 1;
                queue.add(nextPos);
            }
            
            int nextPos = curPos * 2; // *2하는 경우
            if (nextPos > 100000 || nextPos < 0) {
                continue;
            }
            if (visited[nextPos]) {
                continue;
            }
            
            visited[nextPos] = true;
            cnt[nextPos] = cnt[curPos] + 1;
            queue.add(nextPos);
        }
    }
}