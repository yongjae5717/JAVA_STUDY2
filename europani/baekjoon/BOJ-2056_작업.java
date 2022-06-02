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

            int k = Integer.parseInt(st.nextToken());
            for (int j=0; j < k; j++) {
                int order = Integer.parseInt(st.nextToken());
                indegree[i]++;
                graph[order].add(i);
            }
        }
    }

    static void topology() {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i < N+1; i++) {
            result[i]=time[i];
            if (indegree[i]==0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i : graph[now]) {
                indegree[i]--;
                result[i] = Math.max(result[now]+time[i], result[i]);
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(Arrays.stream(result).max().getAsInt());
    }

    public static void main(String[] args) throws IOException {
        input();
        topology();
    }
}