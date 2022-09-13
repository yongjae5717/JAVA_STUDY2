import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r;
    static int[] items;
    static int[][] dp;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n+1];
        dp = new int[n+1][n+1];

        // items 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 초기화 및 입력받기
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        for(int i = 1; i <= n; i++){
            dp[i][i] = 0;
        }
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            dp[a][b] = r;
            dp[b][a] = r;
        }

        // 플로이드 워셜
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int max_cnt = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(dp[i][j] <= m){
                    cnt += items[j];
                }
            }
            max_cnt = Math.max(max_cnt, cnt);
        }

        bw.write(max_cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }



}



