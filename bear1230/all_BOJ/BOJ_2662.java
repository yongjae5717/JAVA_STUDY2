import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] value;
	static int[][] dp;
	static int[][] invested;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		value = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		invested = new int[n+1][m+1];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=1; j<m+1; j++) {
				value[num][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<m+1; i++) {
			for(int j=n; j>0; j--) {
				for(int k=0; k<j+1; k++) {
					if(dp[j][i] < dp[j-k][i-1]+value[k][i]) {
						dp[j][i] = dp[j-k][i-1] + value[k][i];
						invested[j][i] = j-k;
					}
				}
			}
		}
		
		System.out.println(dp[n][m]);
		out(n,m);	
		
	}
	
	static void out(int x, int y) {
		if(y==0)	return;
		out(invested[x][y], y-1);
		System.out.print(x-invested[x][y]+" ");
	}
}