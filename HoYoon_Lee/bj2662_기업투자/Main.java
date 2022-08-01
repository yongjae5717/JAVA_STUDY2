package HoYoon_Lee.bj2662_기업투자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] benefits = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        int[][] results = new int[N + 1][M + 1];

        for(int i = 1; i <= N; i++)
            benefits[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int company = 1; company <= M; company++){
            for(int money = 1; money <= N; money++){
                for(int now = 0; now <= money; now++){
                    if(dp[money][company] < dp[money - now][company - 1] + benefits[now][company]){
                        dp[money][company] = dp[money - now][company - 1] + benefits[now][company];
                        results[money][company] = now;
                    }
                }
            }
        }
        System.out.println(dp[N][M]);

        int x = N;
        int y = M;
        StringBuilder answer = new StringBuilder();
        while(y > 0) {
            answer.insert(0, results[x][y] + " ");
            x -= results[x][y];
            y--;
        }
        System.out.println(answer);

        br.close();
    }
}
