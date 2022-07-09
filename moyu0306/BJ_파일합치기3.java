import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int M;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            if(i!=0)sb.append("\n");
            M = Integer.parseInt(br.readLine());
            long sum = 0;
            String[] nums = br.readLine().split(" ");
            pq = new PriorityQueue<>();
            for (int j = 0; j < M; j++) pq.offer(Long.parseLong(nums[j]));
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                pq.offer(a + b);
                sum += a + b;
            }

            sb.append(sum);
        }
        System.out.println(sb.toString());
    }
}