package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 집하장 N개가 있다.
 * 각 집하장을 연결하는 도로와 비용이 주어진다.
 * 이때 각 집하장에서 다른 집하장으로 최단거리로 가려고 한다.
 * 이때 처음 들러야하는 집하장을 그래프로 출력하는 문제
 * graph[i][i]에는 -를 출력한다.
 * @author Rave
 *
 */
public class Main {

	static final int MAX = 1000000000;

	/**
	 * 플로이드와샬로 푸는 문제
	 * result[i][j] = k로 했다가 틀렸음.
	 * 그래서 result[i][k]로 i에서 k로갈때 먼저 들렸던 곳을 넣어주는 방법으로 바꿈.
	 * 중간에 테스트한다고 answer.append('\n')이 들어있어서 답은 잘 나오는데 계속 틀렸음.
	 * 뻘짓으로 20분정도 날리다가 위 코드 찾음.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n + 1][n + 1];
		int[][] result = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			Arrays.fill(map[i], MAX);
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[first][second] = map[second][first] = cost;
			result[first][second] = second;
			result[second][first] = first;
		}
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if (map[i][k] + map[k][j] < map[i][j]) {
						map[i][j] = map[i][k] + map[k][j];
						result[i][j] = result[i][k];
					}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				answer.append(i == j ? "-" : result[i][j]).append(' ');
			answer.append('\n');
		}
		System.out.print(answer);
	}
}