import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class Coordinate {
        
        double x, y;
        
        public Coordinate(double x, double y) {
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
    
    static int n;
    static boolean[] check;
    static Coordinate[] coordinates;
    static ArrayList<Pair>[] adj;
    
    public static void main(String[] args) throws IOException {
        
        n = parseInt(br.readLine());
        coordinates = new Coordinate[n + 1];
        check = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(parseDouble(st.nextToken()),
                                            parseDouble(st.nextToken()));
        }
        
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                double distance = sqrt(
                    pow(coordinates[j].x - coordinates[i].x, 2)
                        + pow(coordinates[j].y - coordinates[i].y, 2));
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
