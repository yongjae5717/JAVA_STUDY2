import java.io.*;
import java.util.*;

public class Main {
    
    private static class Pair {
        
        int x;
        int distance;
        
        public Pair(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int n;
    static boolean[] isCycled;
    static List<Integer>[] metro;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        n = Integer.parseInt(br.readLine());
        metro = new ArrayList[n + 1];
        isCycled = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            metro[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            metro[first].add(second);
            metro[second].add(first);
        }
        
        // dfs를 통해 순환선 안에 속해있는지 여부 판별하기
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            cycle(i, i, 1);
        }
        
        // bfs를 통해 가장 가까운 순환선 역과의 거리 찾기
        for (int i = 1; i <= n; i++) {
            if (isCycled[i]) {
                sb.append("0 ");
            } else {
                visited = new boolean[n + 1];
                sb.append(findDistance(i) + " ");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    private static int findDistance(int v) {
        Queue<Pair> q = new LinkedList<Pair>();
        visited[v] = true;
        q.add(new Pair(v, 0));
        
        while (!q.isEmpty()) {
            int cur = q.peek().x;
            int distance = q.poll().distance;
            
            if (isCycled[cur]) {
                return distance;
            }
            
            for (int i = 0; i < metro[cur].size(); i++) {
                int next = metro[cur].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Pair(next, distance + 1));
                }
            }
        }
        return 0;
    }
    
    private static void cycle(int startPoint, int v, int cnt) {
        visited[v] = true;
        
        for (int i = 0; i < metro[v].size(); i++) {
            int curV = metro[v].get(i);
            
            if (!visited[curV]) {
                cycle(startPoint, curV, cnt + 1);
            }
            if (cnt >= 3 && curV == startPoint) {
                isCycled[startPoint] = true;
                return;
            }
        }
        visited[v] = false;
    }
}