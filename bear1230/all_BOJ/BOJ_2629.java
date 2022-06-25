import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		int max = 15000;
		boolean[] check = new boolean[max+1];
		boolean[] save = new boolean[max+1];
		check[0] = true;
		save[0] = true;
		
		int left, right;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j <= max ; j++)
				if(check[j]) {
					left = Math.abs(map[i] - j);
					right = Math.abs(map[i] + j);
					save[left] = true;
					save[right] = true;
					save[map[i]] = true;
				}
			for(int j = 0 ; j <= max ; j++)
				check[j] = save[j];
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp <= max && check[tmp])
				System.out.print("Y ");
			else
				System.out.print("N ");
		}
	}
}
