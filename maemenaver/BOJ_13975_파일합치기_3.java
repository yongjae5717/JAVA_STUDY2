import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var line = new StringTokenizer(br.readLine());

        var T = Integer.parseInt(line.nextToken());

        for (int t = 0; t < T; t++) {
            line = new StringTokenizer(br.readLine());
            var K = Integer.parseInt(line.nextToken());

            line = new StringTokenizer(br.readLine());
            PriorityQueue<Long> que = new PriorityQueue<Long>();
            Long sum = 0L;
            for (int k = 0; k < K; k++) {
                var fileSize = Long.parseLong(line.nextToken());

                que.add(fileSize);
            }

            while (que.size() >= 2) {
                var k1 = que.poll();
                var k2 = que.poll();

                sum += k1 + k2;

                que.add(k1 + k2);
            }

            bw.write(Long.toString(sum) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

// 1 3 3 4 4 5 5 5 14 17 21 21 32 35 98
// 3 4 4 5 5 5 14 17 21 21 32 35 98
// 3 5 5 5 7 14 17 21 21 32 35 98
// 5 5 7 8 14 17 21 21 32 35 98
// 7 8 10 14 17 21 21 32 35 98
// 10 14 15 17 21 21 32 35 98
// 15 17 21 21 24 32 35 98
// 21 21 24 32 32 35 98
// 24 32 32 35 42 98
// 32 35 42 56 98
// 42 56 67 98
// 67 98 98
// 98 165