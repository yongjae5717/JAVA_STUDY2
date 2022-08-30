import java.io.*;
import java.util.*;

public class Main {

    public static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static Edge[] edges;
    static long[] costs;
    static int N, M;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // cost 배열 (정점1로부터 다른 정점으로 갈때의 cost)
        costs = new long[N+1];
        for(int i = 1; i <= N; i++){
            costs[i] = INF;
        }
        costs[1] = 0;

        edges = new Edge[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, cost);
        }

        findShortestPath(1);
        boolean isNegativeCycleExist = findNegativeCycle();

        if(isNegativeCycleExist){
            bw.write("-1");
        }
        else{
            for(int i = 2; i <= N; i++){
                if(costs[i] == INF){
                    bw.write("-1" + "\n");
                }
                else{
                    bw.write(costs[i] + "\n");
                }

            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void findShortestPath(int start){
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < M; j++){
                Edge nowEdge = edges[j];
                if(costs[nowEdge.from] != INF){
                    if(costs[nowEdge.to] > costs[nowEdge.from] + nowEdge.cost){
                        costs[nowEdge.to] = costs[nowEdge.from] + nowEdge.cost;
                    }
                }
            }
        }
    }

    public static boolean findNegativeCycle(){
        for(int j = 0; j < M; j++){
            Edge nowEdge = edges[j];
            if(costs[nowEdge.from] != INF){
                if(costs[nowEdge.to] > costs[nowEdge.from] + nowEdge.cost){
                    return true;
                }
            }
        }
        return false;
    }
}



