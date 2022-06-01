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
		int n = Integer.parseInt(br.readLine());
		map = new List[n];
		times = new int[n];
		degree = new int[n];
		for (int i = 0; i < n; i++)
			map[i] = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			degree[i] = count;
			while (count-- > 0) {
				int prev = Integer.parseInt(st.nextToken()) - 1;
				map[prev].add(i);
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			if (degree[i] == 0)
				q.add(i);
		int answer = 0;
		int[] result = new int[n];
		while (!q.isEmpty()) {
			int cur = q.poll();
			result[cur] += times[cur];
			answer = Math.max(answer, result[cur]);
			for (int next : map[cur]) {
				result[next] = Math.max(result[next], result[cur]);
				if (--degree[next] == 0)
					q.add(next);
			}
		}
		System.out.println(answer);
	}
}