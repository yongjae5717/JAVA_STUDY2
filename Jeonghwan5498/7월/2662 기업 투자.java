import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] info, dp, invest;
    static int[] path;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new int[M+1][N+1];
        for(int j = 1; j <= N; j++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int i = 1; i <= M; i++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[M+1][N+1];
        invest = new int[M+1][N+1];
        solve();

        path = new int[M+1];
        getPath(M, N);

        System.out.println(dp[M][N]);
        for(int i = 1; i <= M; i++){
            System.out.print(path[i] + " ");
        }
    }


    public static void solve(){

        // 누적 i개의 회사에 대해서
        for(int i = 1; i <= M; i++){
            // 누적 j원의 투자금에 대해서
            for(int j = 1; j <= N; j++){

                for(int cost = 0; cost <= j; cost++){
                    // i회사에 cost원 투자하고, 나머지 회사에 j - cost원 투자했을때 수익금
                    int val = dp[i-1][j-cost] + info[i][cost];

                    // (i회사에 cost원 투자하고, 나머지 회사에 j - cost원 투자했을 때 수익금) > (i-1 회사에 j원 투자했을 때 수익금) 이라면
                    if (val > dp[i][j]){
                        dp[i][j] = val;

                        // 이 때 누적 j원에 대하여 i회사에 투자하는 금액 : cost
                        invest[i][j] = cost;
                    }
                }
            }
        }
    }

    public static void getPath(int m, int n){
        if(m == 0)
            return;
        path[m] = invest[m][n];
        getPath(m-1, n - path[m]);
    }
}
