import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][3];
		int[] C = new int[n + 1];
		Arrays.fill(C, c);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[j][1] == i && C[arr[j][0]] > 0) {
					int max = Integer.MAX_VALUE;
					for (int k = arr[j][0]; k < i; k++) {
						max = Math.min(max, C[k]);
					}
					if (max == 0)
						continue;
					int take = max > arr[j][2] ? arr[j][2] : max;

					for (int k = arr[j][0]; k < i; k++) {
						C[k] -= take;
					}
					answer += take;
				}
			}
		}
		System.out.println(answer);
	}
}