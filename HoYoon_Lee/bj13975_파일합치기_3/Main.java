package HoYoon_Lee.bj13975_파일합치기_3;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            long answer = 0;
            br.readLine();
            PriorityQueue<Long> pq = Arrays.stream(br.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toCollection(PriorityQueue::new));
            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                answer += sum;
                pq.offer(sum);
            }
            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }
}
