import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int f, s, g, u, d;
    static int[] stairs;
    static boolean[] visited;
    
    static int[] cnt;
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        if (s == g) {
            System.out.print(0);
        } else {
            stairs = new int[]{u, -d};
            visited = new boolean[f + 1];
            cnt = new int[f + 1];
            bfs();
            if (cnt[g] == 0) {
                System.out.print("use the stairs");
            } else {
                System.out.print(cnt[g]);
            }
        }
    }
    
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int curPos = queue.poll();
            
            if (curPos == g) {
                return;
            }
            
            for (int i = 0; i < 2; i++) {
                int nextPos = curPos + stairs[i];
                
                if (nextPos > f || nextPos <= 0) {
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
}