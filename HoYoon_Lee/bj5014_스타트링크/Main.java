package HoYoon_Lee.bj5014_스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final String NO_ROUTE = "use the stairs";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[F + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(S);
        visit[S] = true;

        int cnt = 0;
        boolean isG = false;
        LOOP:
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int now = queue.poll();
                if(now == G) {
                    isG = true;
                    break LOOP;
                }
                int up = now + U;
                int down = now - D;

                if(up <= F && !visit[up]) {
                    queue.offer(up);
                    visit[up] = true;
                }
                if(down > 0 && !visit[down]) {
                    queue.offer(down);
                    visit[down] = true;
                }
            }
            cnt++;
        }
        if(isG) System.out.println(cnt);
        else System.out.println(NO_ROUTE);
        br.close();
    }
}
