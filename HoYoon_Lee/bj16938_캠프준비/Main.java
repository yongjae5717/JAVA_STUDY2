package HoYoon_Lee.bj16938_캠프준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int L;
    private static int R;
    private static int X;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        Arrays.sort(A);

        System.out.println(findCases(-1, 0, 0));
    }

    private static int findCases(int from, int start, int sum){
        int cnt = 0;
        for(int i = start; i < N; i++){
            int newSum = sum + A[i];
            if(from != -1 && L <= newSum && newSum <= R && X <= A[i] - A[from]) cnt++;
            cnt += findCases(from == -1? i : from, i + 1, newSum);

        }
        return cnt;
    }
}
