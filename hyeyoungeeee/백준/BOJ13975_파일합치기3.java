package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13975_파일합치기3 {
    static int T, K;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>();
            for (int j = 0; j < K; j++) {
                pq.offer(Long.valueOf(st.nextToken()));
            }
            long sum = 0;
            while (pq.size() > 1) {
                long c1 = pq.poll();
                long c2 = pq.poll();
                long x1 = c1 + c2;
                sum += x1;
                pq.offer(x1);
            }
            System.out.println(sum);
        }
    }
}
