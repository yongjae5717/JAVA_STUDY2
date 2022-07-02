package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

// 2022-07-02
// 위상정렬 + dp
public class BOJ1005_ACMCraft {
    static int T, N, K, W;
    static int[] Time;
    static ArrayList<ArrayList<Integer>> list;
    static int[] edgeCount;
    static int[] result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BOJ1005_ACMCraft/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            Time = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                Time[j] = Integer.parseInt(st.nextToken());
            }

            edgeCount = new int[N+1];
            list = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                list.get(start).add(next);
                edgeCount[next] += 1;
            }

            W = Integer.parseInt(br.readLine()); // 만들어야 할 건물 번호

            topologicalSort();
            sb.append(result[W] + "\n");

        }
        System.out.print(sb);
    }

    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();

        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if(edgeCount[i] == 0){
                q.offer(i);
            }
            result[i] = Time[i];
        }

        while (!q.isEmpty()){
            int current = q.poll();

            for (int next : list.get(current)) {
                edgeCount[next] -= 1;
                result[next] = Math.max(result[next], result[current] + Time[next]);

                if(edgeCount[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}
