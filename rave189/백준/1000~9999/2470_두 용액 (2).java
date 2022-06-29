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
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int result = Integer.MAX_VALUE;
		int first = -1, second = -1;
		int left = 0, right = n - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (Math.abs(sum) < result) {
				result = Math.abs(sum);
				first = arr[left];
				second = arr[right];
			}
			if (sum > 0)
				right--;
			else
				left++;
		}
		System.out.println(String.format("%d %d", first, second));
	}
}