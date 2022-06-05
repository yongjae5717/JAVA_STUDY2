package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] map;
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = st.nextToken().charAt(0);
		}
		dfs(0, 0, map[0][0] - '0');
		System.out.printf("%d %d\n", max, min);
	}

	public static void dfs(int x, int y, int result) {
		if (x == map.length - 1 && y == map.length - 1) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		for (int i = 0; i < dx.length; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			try {
				if ('0' <= map[nextX][nextY] && map[nextX][nextY] <= '9')
					dfs(nextX, nextY, calc(result, map[nextX][nextY] - '0', map[x][y]));
				else
					dfs(nextX, nextY, result);
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
	}

	public static int calc(int left, int right, char op) {
		if (op == '+')
			return left + right;
		else if (op == '-')
			return left - right;
		else
			return left * right;
	}
}