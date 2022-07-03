import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1005_ACM_Craft {
    static int v;
    static int e;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            time = new int[v + 1];

            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < v + 1; i++) {
                list.add(new ArrayList<>());
            }

            int[] indegree = new int[v + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < v; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                list.get(v1).add(v2);
                indegree[v2]++;
            }

            int target = Integer.parseInt(br.readLine());

            topologicalSort(indegree, list, target);
        }
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> list, int target) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            result[i] = time[i];

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int vertex = q.poll();

            for (Integer i : list.get(vertex)) {
                result[i] = Math.max(result[i], result[vertex] + time[i]);
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result[target]);
    }
}