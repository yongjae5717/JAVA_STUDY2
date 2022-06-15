package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int length = Integer.MAX_VALUE;
		int start = 0, end = 0, sum = 0;
		while (end < n) {
			int nextSum = sum + arr[end];
			if (nextSum >= s) {
				length = Math.min(length, end - start + 1);
				sum -= arr[start++];
			} else
				sum += arr[end++];
			if (start > end) {
				end = start;
				sum = 0;
			}
		}
		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}
}