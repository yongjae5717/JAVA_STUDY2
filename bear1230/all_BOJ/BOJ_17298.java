import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());		
		int[] num = new int[N];		
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && num[stack.peek()] < num[i]) {
				num[stack.pop()] = num[i];
			}
			stack.add(i);
		}		
		while(!stack.isEmpty()) {
			num[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            sb.append(num[i]).append(" ");
        }
		System.out.print(sb);
	}
}