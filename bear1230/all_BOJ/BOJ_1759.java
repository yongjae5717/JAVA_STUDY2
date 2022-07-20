import java.io.*;
import java.util.*;

public class Main {
	static int R, N;
	static int[] charArr, temp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());

		charArr = new int[N];
		temp = new int[R];

		tokens = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			charArr[n] = (int) tokens.nextToken().charAt(0) - 97;
		}
		Arrays.sort(charArr);
		DFS(0, 0);
		System.out.println(sb.toString());

	}

	static void DFS(int cnt, int start) {
		if (cnt == R) {
			int ac = 0;
			int bc = 0;
			for (int i = 0; i < temp.length; i++) {
				if ("aeiou".indexOf((char) (temp[i] + 97)) >= 0) {
					ac++;
				} else {
					bc++;
				}
			}
			if (ac >= 1 && bc >= 2) {
				for (int i = 0; i < temp.length; i++) {
					sb.append((char) (temp[i] + 97));
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < N; i++) {
			temp[cnt] = charArr[i];
			DFS(cnt + 1, i + 1);
		}
	}
}
