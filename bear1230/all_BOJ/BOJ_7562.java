import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Queue<Node> que = new LinkedList<>();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] count = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(count[i], -1);
			}
			String[] s1 = br.readLine().split(" ");
			String[] s2 = br.readLine().split(" ");
			int start_x = Integer.parseInt(s1[0]);
			int start_y = Integer.parseInt(s1[1]);
			int end_x = Integer.parseInt(s2[0]);
			int end_y = Integer.parseInt(s2[1]);

			Node start = new Node(start_x, start_y);
			Node end = new Node(end_x, end_y);
			que.add(start);
			count[start_x][start_y] = 0;

			while (!que.isEmpty()) {
				if (start_x == end_x && start_y == end_y) {
					break;
				}
				Node node = que.remove();
				int x = node.x;
				int y = node.y;
				for (int i = 0; i < 8; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (0 <= nx && nx < n && 0 <= ny && ny < n) {
						if (count[nx][ny] == -1) {
							count[nx][ny] = count[x][y] + 1;
							que.add(new Node(nx, ny));
						}
					}
				}
			}
			System.out.println(count[end.x][end.y]);
		}
	}

}

class Node {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
