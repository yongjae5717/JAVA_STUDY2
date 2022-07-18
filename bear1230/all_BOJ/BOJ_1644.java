import java.io.*;
import java.util.*;

public class Main {
	static int n, answer;
	static boolean check[];
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		answer = 0;
		check = new boolean[n+1];
		
		for(int i = 2; i <= (n+1)/2; i++) {
			for(int j = 2; j*i <= n; j++)
				check[j*i] = true;
		}
		check[1] = true; 
		
		for(int i = 2; i <= n; i++)
			if(!check[i])
				list.add(i);
		solve();
		System.out.println(answer);
	}
	

	public static void solve() {

		for(int i = 0; i < list.size(); i++) {
			int sum = 0;
			for(int j = 0; j+i < list.size(); j++) {
				sum += list.get(i+j);
				if(sum == n) {
					answer++;
					break;
				}
				else if(sum > n)
					break;
			}
		}
	}

}