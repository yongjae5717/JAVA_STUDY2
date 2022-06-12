import java.io.*;
import java.util.*;

class Mirror {
	int row, col, dir, mircnt;

	Mirror(int row, int col, int dir, int mircnt) {
		this.row = row;
		this.col = col;
		this.dir = dir;
		this.mircnt = mircnt;
	}
}

public class Main {

	public static final int[] dx = { 1, 0, -1, 0 };
	public static final int[] dy = { 0, 1, 0, -1 };
	public static int N, M, ans = Integer.MAX_VALUE;
	public static char[][] map;
	public static Queue<Mirror> que;
	public static int dp[][][];

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new char[N][N];
		que = new LinkedList<>();
		dp = new int[N][N][4];

		for (int i = 0; i < N; i++) {
			char[] ch = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
				map[i][j] = ch[j];
				if (map[i][j] == '#')
					que.add(new Mirror(i, j, 0, 0));
			}
		}

		Mirror mi = que.poll();
		map[mi.row][mi.col] = '&';

		bfs();
		System.out.println(ans);
	}

	private static void bfs() {

		Mirror mi = que.poll();
		for (int i = 0; i < 4; i++) {
			que.add(new Mirror(mi.row, mi.col, i, 0));
		}

		while (!que.isEmpty()) {
			Mirror m = que.poll();

			if (dp[m.row][m.col][m.dir] < m.mircnt)
				continue;
			dp[m.row][m.col][m.dir] = m.mircnt;

			if (map[m.row][m.col] == '&') {
				ans = Math.min(ans, m.mircnt);
				continue;
			}

			if (map[m.row][m.col] == '!') {
				que.add(new Mirror(m.row, m.col, (m.dir + 3) % 4, m.mircnt + 1));
				que.add(new Mirror(m.row, m.col, (m.dir + 1) % 4, m.mircnt + 1));
			}

			int nx = m.row + dx[m.dir];
			int ny = m.col + dy[m.dir];
			if (check(nx, ny) || map[nx][ny] == '*')
				continue;

			que.add(new Mirror(nx, ny, m.dir, m.mircnt));
		}
	}

	private static boolean check(int nx, int ny) {
		return nx < 0 || nx >= N || ny < 0 || ny >= N;
	}

}