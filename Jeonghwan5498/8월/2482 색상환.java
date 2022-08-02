import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] DP;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        if(N/2 < K){
            System.out.println(0);
            return;
        }

        DP = new int[N+1][K+1];
        //원형색상환에서 : 첫 번째 색을 골랐을 때 + 첫 번째 색을 고르지 않았을 때
        int answer = (colorCombination(N-3, K-1) + colorCombination(N-1, K)) % 1000000003;
        System.out.println(answer);
    }

    // 선형색상환
    public static int colorCombination(int n, int k) {
        if(n <= 0){
            return 0;
        }
        if(k == 1){
            return n;
        }
        if(k == 0){
            return 1;
        }
        if(n/2 + n%2 < k){
            return 0;
        }
        if(DP[n][k] != 0){
            return DP[n][k];
        }

        // 첫 번째 색을 골랐을 때 + 고르지 않았을 떄
        DP[n][k] = (colorCombination(n-2, k-1) + colorCombination(n-1, k)) % 1000000003;

        return DP[n][k];
    }
}
