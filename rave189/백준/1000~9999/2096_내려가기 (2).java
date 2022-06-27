package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int SIZE = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] score = new int[n][SIZE];
		int[][] maxDp = new int[n][SIZE], minDp = new int[n][SIZE];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < SIZE; j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < SIZE; i++) {
			maxDp[0][i] = score[0][i];
			minDp[0][i] = score[0][i];
		}
		for (int i = 1; i < n; i++) {
			maxDp[i][0] = max(maxDp[i - 1][0], maxDp[i - 1][1]) + score[i][0];
			maxDp[i][1] = max(maxDp[i - 1][0], maxDp[i - 1][1], maxDp[i - 1][2]) + score[i][1];
			maxDp[i][2] = max(maxDp[i - 1][1], maxDp[i - 1][2]) + score[i][2];
			minDp[i][0] = min(minDp[i - 1][0], minDp[i - 1][1]) + score[i][0];
			minDp[i][1] = min(minDp[i - 1][0], minDp[i - 1][1], minDp[i - 1][2]) + score[i][1];
			minDp[i][2] = min(minDp[i - 1][1], minDp[i - 1][2]) + score[i][2];
		}
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < SIZE; i++) {
			max = max(max, maxDp[n - 1][i]);
			min = min(min, minDp[n - 1][i]);
		}
		System.out.println(max + " " + min);
	}

	public static int max(int a, int b, int c) {
		return max(a, max(b, c));
	}

	public static int min(int a, int b, int c) {
		return min(a, min(b, c));
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int min(int a, int b) {
		return a > b ? b : a;
	}
}