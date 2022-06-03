package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] map;
	static int[] times, degree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new List[n];
		times = new int[n];
		degree = new int[n];
		for (int i = 0; i < n; i++)
			map[i] = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			int prev;
			while ((prev = Integer.parseInt(st.nextToken())) != -1) {
				map[prev - 1].add(i);
				degree[i]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			if (degree[i] == 0)
				q.add(i);
		int[] result = new int[n];
		while (!q.isEmpty()) {
			int cur = q.poll();
			result[cur] += times[cur];
			for (int next : map[cur]) {
				result[next] = Math.max(result[next], result[cur]);
				if (--degree[next] == 0)
					q.add(next);
			}
		}
		for (int v : result)
			answer.append(v).append('\n');
		System.out.print(answer);
	}
}