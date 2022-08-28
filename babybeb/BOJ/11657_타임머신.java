import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair {
        
        int v, cost;
        
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static ArrayList<Pair>[] adj; // 인접 리스트
    static long[] dist; // 최소 소요 시간 테이블
    static boolean isInfinite; // 시간을 무한히 오래 전으로 되돌릴 수 있는지 여부
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        dist = new long[n + 1];
        Arrays.fill(dist, 2, dist.length, Long.MAX_VALUE); // 최소 소요 시간 테이블 값 초기화
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) { // 인접 리스트 초기화
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) { // 인접 리스트에 값 넣기
            st = new StringTokenizer(br.readLine());
            adj[parseInt(st.nextToken())].add(
                new Pair(parseInt(st.nextToken()), parseInt(st.nextToken())));
        }
        
        // 벨만-포드 알고리즘 + 음수 순환 여부 확인
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Pair pair : adj[j]) {
                    if (dist[j] != Long.MAX_VALUE && dist[pair.v] > dist[j] + pair.cost) {
                        dist[pair.v] = dist[j] + pair.cost;
                        
                        if (i == n) { // 시간을 무한히 오래 전으로 되돌릴 수 있다면
                            isInfinite = true;
                            System.out.print(-1);
                            return;
                        }
                    }
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            sb.append(dist[i] == Long.MAX_VALUE ? -1 : dist[i]).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}