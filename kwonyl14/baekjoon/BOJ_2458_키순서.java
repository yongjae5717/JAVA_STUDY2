import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 문제 풀이
 * 현재 시작 노드가 쳐다보는 것 외에 노드들을 BFS 탐색 했을 때, 현재 노드를 바라보고 있다면 ans++
 * 바라보고 있지 않으면 바로 i++
 * 
 */


public class Main {
	
	static class Node {
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
		
	}
	
	static int ans, N, M; // N : 학생들의 수, M : 학생들의 키 비교 횟수
	static Node[] adjList, reverseList;
	static boolean[] visited1, visited2, newVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new Node[N+1];
		reverseList = new Node[N+1];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			reverseList[to] = new Node(from, reverseList[to]);
		}
//		입력 확인
//		for (int i = 1; i <= N; i++) {
//			if(adjList[i]==null) continue;
//			System.out.println(i+"번 노드 연결 상태 : "+adjList[i].toString());
//		}
		for (int i = 1; i <= N; i++) {
			visited1 = new boolean[N+1];
			visited2 = new boolean[N+1];
			int a = bfs(i);
//			System.out.print(a);
			int b = sfb(i);
//			System.out.print(" "+b);
//			System.out.println();
			if(a+b == N-1) ans++;
		}
		System.out.println(ans);
	}

	private static int sfb(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited2[start] = true;
		int cnt=0;
		
		int current = 0;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			//adjList[current]가 비어있을 시 고려 할 코드
			
			//현재 노드가 바라보는 정점들을 체크
			for(Node temp = reverseList[current] ; temp != null ; temp = temp.next) {
				int vertex = temp.vertex;
				if(!visited2[vertex]) {//방문하지 않았다면 방문처리
					visited2[vertex] = true;
					queue.offer(vertex);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited1[start] = true;
		int cnt = 0;
		
		int current = 0;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			//adjList[current]가 비어있을 시 고려 할 코드
			
			//현재 노드가 바라보는 정점들을 체크
			for(Node temp = adjList[current] ; temp != null ; temp = temp.next) {
				int vertex = temp.vertex;
				if(!visited1[vertex]) {//방문하지 않았다면 방문처리
					visited1[vertex] = true;
					queue.offer(vertex);
					cnt++;
				}
			}
		}
		return cnt;
	}
}





















