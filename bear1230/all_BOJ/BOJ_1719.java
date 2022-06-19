import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static List<List<Node>> arr = new ArrayList<>();
	private static int[][] map, result;
	private static PriorityQueue<Node> que = new PriorityQueue<>();
	private static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		result = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = INF;
			}
		}
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr.get(s).add(new Node(e, c));
			arr.get(e).add(new Node(s, c));
		}

		for (int i = 1; i <= N; i++) {
			solve(i);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					bw.write("- ");
				else if (i == result[i][j])
					bw.write(j + " ");
				else
					bw.write(result[j][i] + " ");
			}
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int start) {
		que.add(new Node(start, 0));
		map[start][start] = 0;
		result[start][start] = 1;

		while (!que.isEmpty()) {
			Node current = que.poll();
			if (current.cost > map[start][current.v])
				continue;
			for (Node next : arr.get(current.v)) {
				if (map[start][next.v] > map[start][current.v] + next.cost) {
					map[start][next.v] = map[start][current.v] + next.cost;
					que.add(new Node(next.v, map[start][next.v]));
					result[start][next.v] = current.v;
				}
			}
		}
	}

	public static class Node implements Comparable<Node> {
		int v;
		int cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
