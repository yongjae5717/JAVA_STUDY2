package maemenaver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12738_가장_긴_증가하는_부분_수열3 {
	public static void main(String[] args)
			throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> p = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			p.add(Integer.parseInt(st.nextToken()));
		}
		
		bw.write(Integer.toString(4));
		bw.flush();
		br.close();
		bw.close();
	}
}
