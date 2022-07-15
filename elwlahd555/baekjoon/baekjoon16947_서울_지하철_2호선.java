package elwlahd555.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon16947_서울_지하철_2호선 {
    static ArrayList<Integer>[] map;
    static int N;
    static boolean[] cycle;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            map[i] = new ArrayList<>();
        cycle = new boolean[N+1];
        int[] ans = new int[N+1];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            map[start].add(end);
            map[end].add(start);
        }

        for(int i=1; i<=N; i++) {
            if(isCycle(i, i, i))
                break;

            else
                cycle = new boolean[N+1];
        }

        for(int i=1; i<=N; i++) {
            if(cycle[i]) continue;

            int cnt = bfs(i);
            ans[i] = cnt;
        }

        for(int i=1; i<=N; i++)
            System.out.print(ans[i]+" ");
    }

    public static boolean isCycle(int before, int v, int start) {
        cycle[v] = true;

        for(int i=0; i<map[v].size(); i++) {
            int e = map[v].get(i);

            if(!cycle[e]) {
                if(isCycle(v, e, start))
                    return true;
            }

            else if(e!=before && e==start)
                return true;
        }
        cycle[v] = false;

        return false;
    }

    public static int bfs(int v) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.add(new Pair(v, 0));
        visited[v] = true;

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            if(cycle[temp.v])
                return temp.cnt;

            for(int i=0; i<map[temp.v].size(); i++) {
                int e = map[temp.v].get(i);
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(new Pair(e, temp.cnt+1));
                }
            }

        }

        return 0;
    }

    public static class Pair {
        int v;
        int cnt;

        public Pair(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }
}