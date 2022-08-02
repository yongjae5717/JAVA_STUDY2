import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    static int[][] DP = new int[1001][1001];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        int divider = 1000000003;
        for(int i=1;i<N+1; i++){
            DP[0][i] = 1;
            DP[1][i] = i;
        }

        for(int i=2; i<K+1; i++){
            for(int j = 2; j<N+1; j++){
                int val = DP[i][j-1] + DP[i-1][j-2];
                if(val>=divider) val %= divider;
                DP[i][j] = val;
            }
        }

        System.out.println((DP[K-1][N-3] + DP[K][N-1])%divider);

    }

}