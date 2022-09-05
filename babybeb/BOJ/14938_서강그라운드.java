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
    
    static int n, m, r;
    static int[] maxItems;
    static int[] itemCnt;
    static ArrayList<Info>[] adj;
    static long[] d;
    static PriorityQueue<Info> pq = new PriorityQueue();
    static final long MAX = 1501;
    
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        maxItems = new int[n + 1];
        
        itemCnt = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCnt[i] = Integer.parseInt(st.nextToken());
        }
        
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            
            adj[first].add(new Info(second, third));
            adj[second].add(new Info(first, third));
        }
        
        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            maxItems[i] = sumItem();
        }
        
        System.out.print(Arrays.stream(maxItems).max().getAsInt());
    }
    
    private static void dijkstra(int start) {
        
        d = new long[n + 1];
        Arrays.fill(d, MAX);
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
    
    private static int sumItem() {
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] <= m) {
                sum += itemCnt[i];
            }
        }
        
        return sum;
    }
}