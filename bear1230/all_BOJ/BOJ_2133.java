import java.io.*;
 
public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dp = new int[31];
        dp[0] = 1;
        dp[1] = 0;
 
        if(num > 1)
            dp[2] = 3;
        
        for(int i = 4; i <= num; i+=2) {
            dp[i] = 3 * dp[i-2];
            for(int j = 0; j < i-2; j+=2) {
                dp[i] += dp[j] * 2;
            }
        }
       System.out.println(dp[num]);
    } 
}
