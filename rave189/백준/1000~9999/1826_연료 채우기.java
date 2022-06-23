package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트럭의 연료탱크에 구멍이 나서 1km가는데 1L의 연료가 필요하다.
 * 목적지까지 가기위해 주유소를 최소로 방문하려고 할 때, 주유소 방문횟수를 구하는 문제
 * 목적지까지 가지 못하면 -1을 출력한다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 프로그래머스에 트럭보내기랑 비슷한 문제
	 * 왜 생각 못했지?
	 * 분류보고나서 생각남
	 * 맞게 한거같은데 계속 틀렸습니다 나오길래 질문봤엇는데 while문 조건에 <=으로 안해주고 <로 해줘서 틀린 거였음.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<FuelStation> pq = new PriorityQueue<>((v1, v2) -> v1.p - v2.p);
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int location = Integer.parseInt(st.nextToken());
			int fuel = Integer.parseInt(st.nextToken());
			pq.add(new FuelStation(location, fuel));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int destination = Integer.parseInt(st.nextToken());
		int stdFuel = Integer.parseInt(st.nextToken());
		int answer = 0;
		Queue<FuelStation> maxFuelStation = new PriorityQueue<>((v1, v2) -> v2.fuel - v1.fuel);
		while (stdFuel < destination) {
			while (!pq.isEmpty() && pq.peek().p <= stdFuel)
				maxFuelStation.add(pq.poll());
			if (maxFuelStation.isEmpty())
				break;
			FuelStation maxStation = maxFuelStation.poll();
			stdFuel += maxStation.fuel;
			answer++;
		}
		System.out.println(stdFuel >= destination ? answer : -1);
	}
}

class FuelStation {
	int p, fuel;

	public FuelStation(int p, int fuel) {
		this.p = p;
		this.fuel = fuel;
	}
}