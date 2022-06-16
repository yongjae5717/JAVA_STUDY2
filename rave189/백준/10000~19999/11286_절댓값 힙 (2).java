package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> {
			int x1 = Math.abs(v1), x2 = Math.abs(v2);
			if (x1 == x2)
				return v1 - v2;
			return x1 - x2;
		});
		while (n-- > 0) {
			int v = Integer.parseInt(br.readLine());
			if (v != 0)
				pq.add(v);
			else if (!pq.isEmpty())
				answer.append(pq.poll()).append('\n');
			else
				answer.append(0).append('\n');
		}
		System.out.print(answer);
	}
}