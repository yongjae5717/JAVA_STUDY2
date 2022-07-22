package HoYoon_Lee.bj2617_구슬찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[] visit;
    private static int limit;
    private static final Set<Integer> answers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        limit = N / 2;
        List<Integer>[] heavies = new List[N + 1];
        List<Integer>[] lights = new List[N + 1];
        visit = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            heavies[i] = new ArrayList<>();
            lights[i] = new ArrayList<>();
        }

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            lights[heavy].add(light);
            heavies[light].add(heavy);
        }

        for(int i = 1; i <= N; i++){
            Arrays.fill(visit, false);
            countDepth(heavies, i);
            Arrays.fill(visit, false);
            countDepth(lights, i);
        }

        System.out.println(answers.size());
        br.close();
    }

    private static int countDepth(List<Integer>[] list, int node){
        int count = 0;

        for(int next : list[node]) {
            if(visit[next]) continue;
            visit[next] = true;
            count += countDepth(list, next);
        }
        if(count > limit) answers.add(node);
        return ++count;
    }
}