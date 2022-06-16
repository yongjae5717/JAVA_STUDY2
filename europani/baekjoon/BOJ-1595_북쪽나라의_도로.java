import java.util.*;
import java.io.*;

class Main {
    static int N, max, index;
    static List<Edge>[] graph;
    static boolean[] visited;

    static class Edge {
        int to, len;

        Edge(int to, int len) {
            this.to=to;
            this.len=len;
        }

        public String toString() {
            return "(" + to + "," + len + ")";
        }
    }

    static void dfs(int x, int sum) {
        visited[x]=true;
        if (sum >= max) {
            max = sum;            
            index = x;
        }

        for (Edge e : graph[x]) {
            if (!visited[e.to]) {
                dfs(e.to, sum + e.len);
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int e = 0;
      
        graph = new ArrayList[10001];
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        try {
              while(!(line = br.readLine()).isEmpty()) {
                StringTokenizer st = new StringTokenizer(line);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
    
                graph[a].add(new Edge(b, l));
                graph[b].add(new Edge(a, l));
                e++;
            }
        } catch (Exception ex) {}
        
        N = e+1;

        // first DFS
        visited = new boolean[N+1];
        max = -1;
        dfs(1, 0);

        // second DFS
        visited = new boolean[N+1];
        max = -1;
        dfs(index, 0);
        System.out.println(max);
    }
}