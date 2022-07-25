import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[][][] dp;
    static int n, m, c;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =  Integer.parseInt(st.nextToken());
        m =  Integer.parseInt(st.nextToken());
        c =  Integer.parseInt(st.nextToken());

        arr = new int[n];
        dp = new int[m][1<<13][c+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); 
        System.out.println(dfs(0, 0, c));
    }
    
    
    private  static int dfs(int bit, int cur, int weight) {
        if(cur == m || bit == (1<<n) - 1) return 0;

        if(dp[cur][bit][weight] != 0) return dp[cur][bit][weight];

        dp[cur][bit][weight] = Math.max(dp[cur][bit][weight], dfs(bit, cur + 1, c));
        
        for(int i = 0 ; i < n ; i++) {
            if((bit & (1<<i)) == (1<<i)) continue;
            
            if(arr[i] <= weight) {
                dp[cur][bit][weight] = Math.max(dp[cur][bit][weight], dfs(bit | (1<<i), cur, weight - arr[i]) + 1);
            }
        }
        return dp[cur][bit][weight];
    }
}