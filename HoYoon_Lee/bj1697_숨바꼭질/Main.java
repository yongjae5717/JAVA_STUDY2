package HoYoon_Lee.bj1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int END = 100000;
    private static boolean[][] visit = new boolean[END + 1][3];
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        queue.offer(N);
        visit[N][0] = visit[N][1] = visit[N][2] = true;
        MAIN_LOOP:
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0) {
                int now = queue.poll();
                if(now == K) break MAIN_LOOP;

                checkAndOffer(now - 1, 0);
                checkAndOffer(now + 1, 1);
                checkAndOffer(now * 2, 2);
            }
            cnt++;
        }

        System.out.println(cnt);
        br.close();
    }

    private static void checkAndOffer(int next, int index){
        if(next < 0 || END < next || visit[next][index]) return;
        queue.offer(next);
        visit[next][index] = true;
    }
}
