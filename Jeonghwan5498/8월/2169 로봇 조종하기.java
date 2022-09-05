import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static long[][][] dp;
    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dp = new long[N+2][M+2][3];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫 번째 줄 DP
        dp[1][1][2] = map[1][1];
        for(int j = 2; j <= M; j++){
            dp[1][j][2] = dp[1][j-1][2] + map[1][j];
        }
        dp[2][0][0] = dp[1][1][2];
        dp[2][M+1][1] = dp[1][M][2];

        // 다음 번째 줄 DP
        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= M; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][2], dp[i][j-1][0]) + map[i][j];
            }
            for(int j = M; j >= 1; j--){
                dp[i][j][1] = Math.max(dp[i-1][j][2], dp[i][j+1][1]) + map[i][j];
            }
            for(int j = 1; j <= M; j++){
                dp[i][j][2] = Math.max(dp[i][j][0], dp[i][j][1]);
            }

            dp[i+1][0][0] = dp[i][1][2];
            dp[i+1][M+1][1] = dp[i][M][2];
        }

        bw.write(dp[N][M][2] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}



