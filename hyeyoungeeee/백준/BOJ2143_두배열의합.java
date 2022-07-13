package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2143_두배열의합 {
    static int N, M;
    static long T;
    static long[] a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        a = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        b = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        // A의 sub
        for (int i = 0; i < N; i++) {
            long window = a[i];
            subA.add(window);
            for (int j = i + 1; j < N; j++) {
                window += a[j];
                subA.add(window);
            }
        }

        // B의 sub
        for (int i = 0; i < M; i++) {
            long window = b[i];
            subB.add(window);
            for (int j = i + 1; j < M; j++) {
                window += b[j];
                subB.add(window);
            }
        }

        // subA 정렬
        Collections.sort(subA);
        // subB 정렬

        // 내림차순으로 하고 포인터 ++만 할수있음
        Collections.sort(subB, Comparator.reverseOrder());

        // 두 sub들 비교 -> 2pointer
        int pa = 0;
        int pb = 0;
        long result = 0;

        while (pa < subA.size() && pb < subB.size()) {

            long currentA = subA.get(pa);
            long target = T - currentA;
            // currentB == target -> 동률 체크 subA, subB 같은 수 개수 체크. pa, pb 둘다 이동(개수만큼)
            if(subB.get(pb) == target){
                long countA = 0;
                long countB = 0;
                while ((pa < subA.size()) && (subA.get(pa) == currentA)){
                    countA++;
                    pa++;
                }
                while ((pb < subB.size()) && (subB.get(pb) == target)){
                    countB++;
                    pb++;
                }
                result += countA * countB;
            }
            // currentB > target -> pb+
            else if( subB.get(pb) > target){
                pb++;
            }
            // currentB < target -> pa+
            else{
                pa++;
            }
        }
        System.out.println(result);

    }
}
