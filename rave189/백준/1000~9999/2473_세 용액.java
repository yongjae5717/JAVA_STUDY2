package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		long first = -1, second = -1, third = -1, result = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int left = i + 1, right = n - 1;
			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				if (Math.abs(sum) < result) {
					result = Math.abs(sum);
					first = arr[i];
					second = arr[left];
					third = arr[right];
				}
				if (sum > 0)
					right--;
				else
					left++;
			}
		}
		System.out.println(String.format("%d %d %d", first, second, third));
	}
}