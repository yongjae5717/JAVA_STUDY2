package HoYoon_Lee.bj1508_레이스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] available;
    private static String[] referees;
    private static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        available = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        referees = new String[K];
        Arrays.fill(referees, "0");

        int start = 0;
        int end = N;

        while (start <= end){
            int mid = (start + end) / 2;
            int cnt = 1;
            int idx = 0;
            for(int i = 0; i < K; i++){
                if(available[i] - available[idx] >= mid){
                    idx = i;
                    cnt++;
                }
            }
            if(cnt < M)
                end = mid - 1;
            else
                start = mid + 1;
        }
        int idx = 0;
        referees[idx] = "1";
        for(int i = 0; i < K; i++){
            if(available[i] - available[idx] >= end){
                idx = i;
                referees[i] = "1";
            }
        }
        System.out.println(String.join(" ", referees));

        br.close();
    }
}
