import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[] res = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			arr[from][to] = 1;
			res[from]++;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(i==k) continue;
				for (int j = 0; j < N; j++) {
					if(i==j || j==k) continue;
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						if(arr[i][j] != 1) res[i]++;
						arr[i][j] = 1;
					}
					
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[j][i] == 1) res[i]++;
			}
			if(res[i] == N-1) ans++;
		}
		System.out.println(ans);
	}

}