import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기가 N인 수열 입력받기
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        // 팰린드롬 DP 배열 생성
        dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(checkPalindrome(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    public static int checkPalindrome(int a, int b) {

        if(dp[a][b] != -1)
            return(dp[a][b]);

        if(arr[a] != arr[b]){
            dp[a][b] = 0;
        }
        else{
            if(a == b || a + 1 == b){
                dp[a][b] = 1;
            }
            else{
                dp[a][b] = checkPalindrome(a+1, b-1);
            }
        }
        return dp[a][b];
    }
}
