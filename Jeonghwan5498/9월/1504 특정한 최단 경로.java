import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    static int N, E;
    static ArrayList<ArrayList<Edge>> edges;
    static final int INF = 200000000;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            edges.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.get(from).add(new Edge(to, cost));
            edges.get(to).add(new Edge(from, cost));
        }
        visited = new boolean[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int res1 = dijkstra(1,a) + dijkstra(a,b) + dijkstra(b,N);
        int res2 = dijkstra(1,b) + dijkstra(b,a) + dijkstra(a,N);
        int res = Math.min(res1, res2);
        int ans = (res >= INF) ? -1 : res;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start,  int end){
        Arrays.fill(visited, false);
        Arrays.fill(dp, INF);
        dp[start] = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(start, 0));

        while(!pQ.isEmpty()){
            Edge curEdge = pQ.poll();
            int curNode = curEdge.to;

            if(visited[curNode])
                continue;
            visited[curNode] = true;

            for(Edge edge : edges.get(curNode)){
                int nextNode = edge.to;
                int nextCost = edge.cost;

                if(!visited[nextNode] && (dp[nextNode] > dp[curNode] + nextCost)){
                    dp[nextNode] = dp[curNode] + nextCost;
                    pQ.add(new Edge(nextNode, dp[nextNode]));
                }
            }
        }
        return dp[end];
    }
}



