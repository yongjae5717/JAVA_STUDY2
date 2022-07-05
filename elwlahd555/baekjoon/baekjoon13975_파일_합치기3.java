package elwlahd555.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon13975_파일_합치기3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int T,N;
	static Queue<Long> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(input.readLine());
			pq = new PriorityQueue<>();
			tokens = new StringTokenizer(input.readLine());
			for(int n=0; n<N; n++) {
				pq.offer(Long.parseLong(tokens.nextToken()));
			}
			
			long answer = 0;
			long sum = 0;
			while(true) {
				long num1 = pq.poll();
				long num2 = pq.poll();
				sum = num1 + num2;
				
				answer += sum;
				
				if(pq.isEmpty()) {
					break;
				}
				pq.offer(sum);
			}
			output.append(answer + "\n");
		}
		output.close();
	}

	static String src =
			"2\r\n" + 
			"4\r\n" + 
			"40 30 30 50\r\n" + 
			"15\r\n" + 
			"1 21 3 4 5 35 5 4 3 5 98 21 14 17 32";
}