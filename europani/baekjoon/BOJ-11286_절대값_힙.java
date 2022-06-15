import java.util.*;
import java.io.*;

class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((n1, n2) -> {
                if (Math.abs(n1) == Math.abs(n2)) {
                    return n1 - n2;
                } else {
                   return Math.abs(n1) - Math.abs(n2);          
                }
            });

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    int out = pq.poll();
                    sb.append(out + "\n");
                }
            } else {
                pq.offer(n);
            }
        }
        System.out.println(sb);
    }
}