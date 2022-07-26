import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static Pos[] arr;
	static int[] parent; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new Pos[N+1];

		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			arr[i] = new Pos(tx,ty);
		}

		parent = new int[N+1];
		for(int i=1; i<N+1; i++) {
			parent[i] = i;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(find(from) != find(to)) {
				parent[find(from)] = find(to);
			}
		}
		double ans = kruskal();
		System.out.printf("%.2f\n", ans);
		
	}
    
	private static double kruskal() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		double sum = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=i+1; j<N+1; j++) {
				long tx = arr[i].x - arr[j].x;
				long ty = arr[i].y - arr[j].y;
				double len = Math.sqrt(Math.pow(tx, 2) + Math.pow(ty, 2));
				pq.offer(new Edge(i,j, len));
			}
		}
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(find(cur.n1) != find(cur.n2)) {
				parent[find(cur.n1)] = find(cur.n2);
				sum += cur.len;
			}			
			
		}
		return sum;
		
		
	}
    
	private static int find(int v) {
		if(parent[v] == v){
			return v;
		}
		parent[v] = find(parent[v]);
		return parent[v];
	}
    
    static class Pos{
		int x,y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    
	static class Edge implements Comparable<Edge>{
		int n1,n2;
		double len;
		public Edge(int n1, int n2, double len) {
			this.n1 = n1;
			this.n2 = n2;
			this.len = len;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(len, o.len);
		}
		
	}

}