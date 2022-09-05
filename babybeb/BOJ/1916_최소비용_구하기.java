import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    private static class Info implements Comparable<Info> {
        
        int v;
        long cost;
        
        public Info(int v, long cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Info o) {
            return (int) (this.cost - o.cost);
        }
    }
    
    static int n, m, start, end;
    static ArrayList<Info>[] adj;
    static long[] d;
    static PriorityQueue<Info> pq = new PriorityQueue();
    static long max = 9999900000L;
    
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            
            adj[first].add(new Info(second, third));
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        
        System.out.print(d[end]);
    }
    
    private static void dijkstra(int start) {
        
        d = new long[n + 1];
        Arrays.fill(d, max);
        d[start] = 0;
        
        pq.add(new Info(start, d[start]));
        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (d[cur.v] != cur.cost) { // 최소비용 배열에 있는 cur의 비용과 현재 cur의 비용이 다른 경우
                continue;
            }
            for (Info next : adj[cur.v]) {
                // 최소비용 배열에 있는 next의 비용이 cur을 거쳐 next로 가는 비용보다 더 큰 경우
                if (d[next.v] > d[cur.v] + next.cost) {
                    d[next.v] = d[cur.v] + next.cost;
                    pq.add(new Info(next.v, d[next.v]));
                }
            }
        }
    }
}