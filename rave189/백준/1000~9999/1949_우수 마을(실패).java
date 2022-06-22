package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static HashSet<Integer>[] map;
	static int[] peopleOfCountry, parent, child;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		peopleOfCountry = new int[n + 1];
		parent = new int[n + 1];
		child = new int[n + 1];
		map = new HashSet[n + 1];
		for (int i = 1; i <= n; i++) {
			peopleOfCountry[i] = Integer.parseInt(st.nextToken());
			map[i] = new HashSet<>();
		}
		while (--n > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			map[first].add(second);
			map[second].add(first);
		}
		System.out.println(findGreatTown(1, -1));
	}

	public static int findGreatTown(int cur, int prev) {
		if (child[cur] > 0)
			return child[cur];
		int sumOfChild = 0;
		int sumOfGrandChild = 0;
		for (int next : map[cur]) {
			if (next == prev)
				continue;
			sumOfChild += peopleOfCountry[next];
			sumOfGrandChild += findGreatTown(next, cur);
		}
		return -1;
	}
}