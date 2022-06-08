import java.util.*;

class Solution {

	private static int LAST_TIME = 1320;

	public int solution(int n, int m, int[][] timetable) {
		int[] cnt = new int[LAST_TIME + 1];
		for (int[] time : timetable) {
			int start = time[0];
			int end = time[1];

			for (int i = start; i <= end; ++i) {
				cnt[i]++;
			}
		}

		int ans = 0;
		for (int i = 0; i < cnt.length; ++i) {
			if (ans < cnt[i]) {
				ans = cnt[i];
			}
		}

		if (ans == 1) {
			return 0;
		}

		System.out.println(ans);

		for (int dist = 2 * n - 2; dist > 0; --dist) {
			for (int i = 0; i < n; ++i) {
				List<Node> customers = new ArrayList<>();
				for (int y = 0; y < n; ++y) {
					for (int x = 0; x < n; ++x) {
						if (y == 0 && x < i) {
							continue;
						}

						boolean check = true;
						for (Node node : customers) {
							int tmp = Math.abs(node.y - y) + Math.abs(node.x - x);
							if (tmp < dist) {
								check = false;
								break;
							}
						}

						if (check) {
							customers.add(new Node(x, y));
							if (customers.size() == ans) {
								return dist;
							}
						}
					}
				}
			}
		}
		return -1;
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
