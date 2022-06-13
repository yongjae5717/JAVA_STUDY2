package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
				if (i == j)
					map[i][j] = true;
			}
		}
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (map[i][k] && map[k][j])
						map[i][j] = true;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cur = Integer.parseInt(st.nextToken()) - 1;
		while (st.hasMoreTokens()) {
			int next = Integer.parseInt(st.nextToken()) - 1;
			if (!map[cur][next]) {
				System.out.println("NO");
				return;
			}
			cur = next;
		}
		System.out.println("YES");
	}
}