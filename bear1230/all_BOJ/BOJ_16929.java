import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static char map[][];
	static boolean visited[][];

	static int[][] count;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		count = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dfs(i, j, map[i][j], 1)) {
					System.out.println("Yes");
					return;
				}
			}
		}

		System.out.println("No");

	}

	static boolean dfs(int x, int y, int color, int length) {
		if (visited[x][y])
			return length - count[x][y] >= 4;
		visited[x][y] = true;
		count[x][y] = length;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[nx][ny] == color) {
					if (dfs(nx, ny, color, length + 1)) {
						return true;

					}
				}
			}
		}
		return false;

	}

}
