package studyGroup.july.july8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 값을 잘 읽고 큰 경우 long 으로 바꿔준다.
// int : 2,147,483,647 (2의 31승 - 1) 10억

/*

kk 의 1,000,000
파일의 크기는 10,000을 초과하지 않는다

100,000,000,000 천억

 */

public class 백준13975파일합치기3 {

    static int k;
    static long cost;
    static long[] answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        answer = new long[test];

        for(int t = 0; t < test; t++)
        {
            k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }


            cost = 0L;

            while (pq.size() != 1) {
                long one = pq.poll();
                long two = pq.poll();

                cost += one + two;
                pq.add(one + two);
            }

            answer[t] = cost;

        }

        for (long i : answer) {
            System.out.println(i);
        }
    }
}
