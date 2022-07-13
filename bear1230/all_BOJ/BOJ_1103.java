import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int[][] time;
	static int answer;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		time = new int[N][M];
		for (int i = 0;i < N;i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0;j < M;j++) {
				if (arr[j] == 'H') {
					map[i][j] = 0;
				} else {
					map[i][j] = arr[j] - '0';
				}
			}
		}
        
		dfs(0, 0, 1);
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(answer);			
		}
	}
	
	public static void dfs(int y, int x, int cnt) {	
		visited[y][x] = true;
		time[y][x] = cnt;
		answer = Math.max(answer, cnt);
		for (int i = 0;i < 4;i++) {
			int ny = y + dy[i] * map[y][x];
			int nx = x + dx[i] * map[y][x];
			if (!canMove(ny, nx) || map[ny][nx] == 0) {
				continue;
			}
			if (visited[ny][nx]) {
				flag = true;
				return;
			}
			if (time[ny][nx] > cnt) {
				continue;
			}
			dfs(ny, nx, cnt + 1);				
		}
		visited[y][x] = false;
		
	}

	public static boolean canMove(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
