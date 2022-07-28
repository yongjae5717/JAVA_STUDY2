import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int n, m;
    static int[] numbers;
    static int[][] memo;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        numbers = new int[n + 1];
        memo = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= n; i++) {
            memo[i][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (numbers[i] == numbers[i + 1]) {
                memo[i][i + 1] = 1;
            }
        }
        
        for (int k = 2; k < n; k++) {
            for (int i = 1; i + k <= n; i++) {
                if (numbers[i] == numbers[i + k] && memo[i + 1][i + k - 1] == 1) {
                    memo[i][i + k] = 1;
                }
            }
        }
        
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(memo[s][e] + "\n");
        }
        
        System.out.print(sb.toString());
    }
}