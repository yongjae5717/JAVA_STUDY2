import java.io.*;
import java.util.*;

public class Main {

    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    static int m, n;
    static PriorityQueue<Edge> graph;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(m == 0 && n == 0){
                break;
            }

            // 그래프 입력 및 정렬
            int total_cost = 0;
            graph = new PriorityQueue<>();
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());;
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.add(new Edge(from, to, cost));
                total_cost += cost;
            }


            // 분리집합 생성
            parent = new int[m];
            for(int i = 0; i < m; i++){
                parent[i] = i;
            }

            int cnt = 0, sum_cost = 0;
            while(!graph.isEmpty()){
                Edge edge = graph.poll();
                if(find(edge.from) != find(edge.to)){
                    union(edge.from, edge. to);
                    cnt++;
                    sum_cost += edge.cost;
                }
                if(cnt == m-1)
                    break;
            }
            bw.write((total_cost - sum_cost) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }
        else{
            return find(parent[a]);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }
}



