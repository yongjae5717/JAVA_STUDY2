package HoYoon_Lee.bj2482_색상환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int mod = 1000000003;
    private static long[][] dp;
    private static boolean[] visit;
    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp = new long[N][K + 1];
        visit = new boolean[N];

        System.out.println(findNumberOfCase(0, K - 1) % mod);

        br.close();
    }

    private static long findNumberOfCase(int start, int number){
        long result = 0;

        if(number == 0) {
            if(visit[(number + 1) % N]) return 0;
            else return 1;
        }

        for(int i = start; i < N; i++){
            if(visit[i]) continue;
            long r;
            if(dp[i][number] != 0) {
                r = dp[i][number];
            }
            else {
                visit[i] = true;
                r = findNumberOfCase(i + 2, number - 1);
                dp[i][number] = r;
                visit[i] = false;
            }
            result += r;
        }

        return result;
    }
}
