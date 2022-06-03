import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[] time, indegree;
    static ArrayList<Integer>[] graph;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        time = new int[N+1];
        indegree = new int[N+1];
        graph = new ArrayList[N+1];
        for (int i=1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
      
        for (int i=1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i]=t;

           while (true) {
                int k = Integer.parseInt(st.nextToken());
                if (k == -1) break;
            
                indegree[i]++;
                graph[k].add(i);
            } 
        }        
    }

    static void topology() {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];

        for (int i=1; i<= N; i++) {
            result[i] = time[i];
            if (indegree[i]==0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int x : graph[now]) {
                indegree[x]--;
                result[x] = Math.max(result[now]+time[x], result[x]);
                if (indegree[x] == 0) {
                    q.offer(x);
                }
            }
        }
        
        for (int i=1; i<= N; i++) {
            System.out.println(result[i]);
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();
        topology();
    }
}