package BOJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 나라에는 최대 10000개의 도시가 있다.
 * 이 도시는 임의의 두 도시간 이동하는 경로가 유일하도록 도로가 설계되어 있다.
 * 이 때, 두 도시 간의 거리가 가장 먼 거리를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	static final int SIZE = 10000;
	static List<City>[] map;

	/**
	 * 다익스트라인줄알고 보고있었는데 아니었음.
	 * 경로가 유일한거면 트리인데...
	 * 도시가 10000개여서 브루트포스가 가능한것도 의외였음.
	 * 시간복잡도 계산하는 습관좀 들여야할 거 같음
	 * 
	 * 도시가 1개만 있는 경우 입력 자체가 없을 수 있음.
	 * 그래서 NoSuchElementException이 나옴.
	 * 에러 잡아주니 문제가 풀림.
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		map = new List[SIZE];
		for (int i = 0; i < SIZE; i++)
			map[i] = new ArrayList<>();
		try {
			while (scanner.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(scanner.nextLine());
				int first = Integer.parseInt(st.nextToken()) - 1;
				int second = Integer.parseInt(st.nextToken()) - 1;
				int cost = Integer.parseInt(st.nextToken());
				map[first].add(new City(second, cost));
				map[second].add(new City(first, cost));
			}
		} catch (NoSuchElementException e) {
		}
		int answer = 0;
		for (int i = 0; i < SIZE; i++) {
			if (map[i].size() == 0)
				continue;
			answer = Math.max(answer, dfs(i, -1, 0));
		}
		System.out.println(answer);
	}

	public static int dfs(int cur, int prev, int cost) {
		int max = cost;
		for (City next : map[cur]) {
			if (next.p == prev)
				continue;
			max = Math.max(max, dfs(next.p, cur, cost + next.cost));
		}
		return max;
	}
}

class City {
	int p, cost;

	public City(int p, int cost) {
		this.p = p;
		this.cost = cost;
	}
}