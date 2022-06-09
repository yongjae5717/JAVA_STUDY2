package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int[] increase = new int[n];
		int[] decrease = new int[n];
		for (int i = 0; i < n; i++) {
			increase[i] = 1;
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j])
					increase[i] = max(increase[i], increase[j] + 1);
		}
		for (int i = n - 1; i >= 0; i--) {
			decrease[i] = 1;
			for (int j = n - 1; j > i; j--)
				if (arr[i] > arr[j])
					decrease[i] = max(decrease[i], decrease[j] + 1);
		}
		int answer = 0;
		for (int i = 0; i < n; i++)
			answer = max(answer, increase[i] + decrease[i] - 1);
		System.out.println(answer);
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}