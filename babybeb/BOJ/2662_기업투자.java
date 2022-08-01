import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m;
    static int[][] v, dp, path;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];
        path = new int[m + 1][n + 1];
        costs = new int[m + 1];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= m; j++) {
                v[j][cost] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= j; k++) {
                    if (dp[i - 1][j - k] + v[i][k] > dp[i][j]) {
                        dp[i][j] = dp[i - 1][j - k] + v[i][k];
                        path[i][j] = k;
                    }
                }
            }
        }
        
        System.out.println(dp[m][n]);
        
        int temp = m;
        while (temp > 0) {
            costs[temp] = path[temp][n];
            n -= costs[temp];
            temp--;
        }
        
        for (int i = 1; i <= m; i++) {
            System.out.print(costs[i] + " ");
        }
    }
}