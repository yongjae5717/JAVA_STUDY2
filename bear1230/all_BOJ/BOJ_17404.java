import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int [n][3];
		int[][] dp = new int [n+1][3];
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		for (int k=0; k<3; k++) {
			for (int i=0; i<3; i++) {
				dp[0][i] = 10000001; 
			}
			dp[0][k] = map[0][k];
			for (int i=1; i<n; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
				dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + map[i][2];
			}
			for (int i=0; i<3; i++) {
				if (i==k) continue;
				min = Math.min(min, dp[n-1][i]);
			}
		}
		System.out.println(min);
	}
}