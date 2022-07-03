import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list;
	static int[] cost;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			cost = new int[N];
			list = new ArrayList[N];
			dp = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<Integer>();
				dp[i] = -1;
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				list[y].add(x);
			}

			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken()) - 1;

			System.out.println(dfs(W));
		}
	}

	public static int dfs(int root) {
		if (dp[root] > -1) {
			return dp[root];
		}

		int max_cost = 0;
		for (int i = 0; i < list[root].size(); i++) {
			max_cost = Math.max(max_cost, dfs(list[root].get(i)));
		}

		return dp[root] = max_cost + cost[root];
	}
}
