import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    private static class Info implements Comparable<Info> {
        
        int v, cost;
        
        public Info(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Info o) {
            return this.cost - o.cost;
        }
    }
    
    static int n, e, v1, v2;
    static ArrayList<Info>[] adj;
    static int[] d;
    static PriorityQueue<Info> pq = new PriorityQueue();
    static int max = 200000000;
    
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adj[a].add(new Info(b, c));
            adj[b].add(new Info(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        // 1 to a
        dijkstra(1);
        int oneToV1 = d[v1];
        int oneToV2 = d[v2];
        
        dijkstra(v1);
        int V1ToV2 = d[v2];
        int V1ToN = d[n];
        
        dijkstra(v2);
        int V2ToN = d[n];
        
        if (V1ToV2 == max || (oneToV1 == max && oneToV2 == max) || (V2ToN == max && V1ToN == max)
            || (oneToV2 == max && V2ToN == max) || (oneToV1 == max && V1ToN == max)) {
            System.out.print(-1);
            return;
        }
        
        int ans = Math.min(oneToV1 + V1ToV2 + V2ToN, oneToV2 + V1ToV2 + V1ToN);
        System.out.print(ans);
    }
    
    private static void dijkstra(int start) {
        d = new int[n + 1];
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