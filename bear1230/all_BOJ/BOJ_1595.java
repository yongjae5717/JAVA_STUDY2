import java.io.*;
import java.util.*;

public class Main {
	static List<Node>[] list;
	static boolean[] check;
	static int idx;
	static long max = -1;
	public static void main(String[] args) throws IOException{
		int f = -1;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			StringTokenizer st;
			String line;
			
			list = new ArrayList[10001];
			for(int i=0; i<10001; i++) {
				list[i] = new ArrayList<>();
			}
			
			while(!(line = br.readLine()).isEmpty()) {
				st = new StringTokenizer(line);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				f = a;
				list[a].add(new Node(b,v));
				list[b].add(new Node(a,v));
			}
		}catch(Exception e) {}
		
		if(f == -1) {
			System.out.println(0);
			return;
		}
			
		check = new boolean[10001];
		check[1] = true;
		dfs(1,0);
		
		Arrays.fill(check, false);
		check[idx] = true;
		max = -1;
		dfs(idx,0);
		System.out.println(max);
	}
	
	static void dfs(int here, long cost) {
		for(Node node : list[here]) {
			if(check[node.to]) continue;
			long sum = cost + node.value;
			check[node.to] = true;
			if(max < sum) {
				idx = node.to;
				max = sum;
			}
			dfs(node.to, sum);
		}
	}
  
    static class Node{
		int to;
		int value;
		
		Node(int to, int value){
			this.to = to;
			this.value = value;
		}
	}
}