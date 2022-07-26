import java.io.*;
import java.util.*;

/* 맞왜틀...? */

public class Main {
    
    static class Coordinate {
        
        long x, y;
        
        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Pair implements Comparable<Pair> {
        
        double cost;
        int v;
        
        public Pair(double cost, int v) {
            this.cost = cost;
            this.v = v;
        }
        
        @Override
        public int compareTo(Pair o) {
            
            if (this.cost > o.cost) {
                return 1;
            } else if (this.cost < o.cost) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m;
    static boolean[] check;
    static Coordinate[] coordinates;
    static boolean[][] existed;
    static ArrayList<Pair>[] adj;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        coordinates = new Coordinate[n + 1];
        check = new boolean[n + 1];
        existed = new boolean[n + 1][n + 1];
        adj = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()),
                                            Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            existed[first][second] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (existed[i][j]) { // 이미 연결되어 있어 새로 만드는 cost가 0인 경우에는 cost 0으로 만들어 준다
                    adj[i].add(new Pair(0, j));
                    adj[j].add(new Pair(0, i));
                    continue;
                }
                double distance = Math.sqrt(
                    Math.pow(coordinates[j].x - coordinates[i].x, 2) + Math.pow(
                        coordinates[j].y - coordinates[i].y, 2));
                adj[i].add(new Pair(distance, j));
                adj[j].add(new Pair(distance, i));
            }
        }
        
        int cnt = 0;
        double ans = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        check[1] = true;
        for (Pair pair : adj[1]) {
            pq.add(pair);
        }
        
        while (cnt < n - 1) {
            
            double cost = pq.peek().cost;
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
        
        System.out.printf("%.2f", ans);
    }
}