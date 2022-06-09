package Programmers;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = {5, 2, 3, 3, 5, 3};
		System.out.println(solution.solution(a));
	}
}

class Solution {
	Map<Integer, Integer> frequency = new HashMap<>();

	public int solution(int[] a) {
		int answer = 0;
		for (int v : a)
			frequency.put(v, frequency.getOrDefault(v, 0) + 1);
		for (int element : frequency.keySet()) {
			if (frequency.get(element) <= answer)
				continue;
			int result = 0;
			for (int i = 1; i < a.length; i++) {
				if ((a[i] != element && a[i - 1] != element) || a[i] == a[i - 1])
					continue;
				result++;
				i++;
			}
			answer = Math.max(answer, result);
		}
		return answer;
	}
}