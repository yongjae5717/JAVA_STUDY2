import java.io.*;
import java.util.*;

public class Main {
    
    static class Pair implements Comparable<Pair> {
        
        int cost, v;
        
        public Pair(int cost, int v) {
            this.cost = cost;
            this.v = v;
        }
        
        
        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int m, n, weight, cnt, ans;
    static boolean[] check;
    static ArrayList<Pair>[] adj;
    static PriorityQueue<Pair> pq;
    
    public static void main(String[] args) throws IOException {
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) { // 테케가 끝났을 경우 종료
                break;
            }
            
            check = new boolean[m];
            adj = new ArrayList[m];
            weight = 0;
            cnt = 0;
            ans = 0;
            
            for (int i = 0; i < m; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                adj[first].add(new Pair(cost, second));
                adj[second].add(new Pair(cost, first));
                weight += cost;
            }
            
            pq = new PriorityQueue<Pair>();
            check[1] = true;
            for (Pair pair : adj[1]) {
                pq.add(pair);
            }
            
            while (cnt < m - 1) {
                int cost = pq.peek().cost;
                int v = pq.poll().v;
                if (check[v]) {
                    continue;
                }
                
                check[v] = true;
                ans += cost;
                cnt++;
                
                for (Pair pair : adj[v]) {
                    if (!check[pair.v]) {
                        pq.add(pair);
                    }
                }
            }
            
            sb.append(weight - ans + "\n");
        }
        System.out.print(sb.toString());
    }
}