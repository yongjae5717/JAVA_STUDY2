// 블로그 참조 https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-3665%EB%B2%88-%EC%B5%9C%EC%A2%85-%EC%88%9C%EC%9C%84-Java-Python
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] indegree;
	static boolean[][] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			indegree = new int[N + 1];
			edges = new boolean[N + 1][N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				indegree[num] = i;

				for (int j = 1; j <= N; j++) {
					if (j != num && !edges[j][num])
						edges[num][j] = true;
				}
			}

			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				swap(n1, n2);
			}
			bw.write(topologicalSort() + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static String topologicalSort() {
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				que.offer(i);
		}

		for (int i = 1; i <= N; i++) { // 정점 개수만큼 반복
			if (que.size() == 0)
				return "IMPOSSIBLE";
			if (que.size() > 1)
				return "?";
			int cur = que.poll();
			sb.append(cur + " ");

			for (int j = 1; j <= N; j++) {
				if (edges[cur][j]) {
					edges[cur][j] = false;
					if (--indegree[j] == 0)
						que.offer(j);
				}
			}
		}
		return sb.toString();
	}

	private static void swap(int n1, int n2) {
		if (edges[n1][n2]) {
			edges[n1][n2] = false;
			edges[n2][n1] = true;
			indegree[n1]++;
			indegree[n2]--;

		} else {
			edges[n1][n2] = true;
			edges[n2][n1] = false;
			indegree[n1]--;
			indegree[n2]++;
		}
	}
}