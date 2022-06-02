import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static LinkedList<Integer>[] adjList;
    static int[] times;
    static int[] left;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjList = new LinkedList[N + 1];
        times = new int[N + 1];
        left = new int[N + 1];
        pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        int current = 0;
        for (int i = 0; i < N + 1; i++) adjList[i] = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            times[i] = Integer.parseInt(stk.nextToken());
            left[i] = Integer.parseInt(stk.nextToken());
            if (left[i] == 0) {
                pq.offer(new int[]{i, times[i]});
            }
            while (stk.hasMoreTokens()) {
                adjList[Integer.parseInt(stk.nextToken())].add(i);
            }
        }

        while (!pq.isEmpty()) {
            int[] job = pq.poll();
            current = job[1];
            for (int edge : adjList[job[0]]) {
                if (--left[edge] == 0) {
                    pq.offer(new int[]{edge, current + times[edge]});
                }
            }
        }

        System.out.println(current);
    }
}