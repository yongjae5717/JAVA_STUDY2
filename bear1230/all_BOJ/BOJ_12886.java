import java.io.*;
import java.util.*;
 
public class Main {
	static boolean[][] visited;
	static int[] tmp = new int[3];
	static int sum = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		tmp[0] = Integer.parseInt(st.nextToken());
		tmp[1] = Integer.parseInt(st.nextToken());
		tmp[2] = Integer.parseInt(st.nextToken());
        
		sum = tmp[0] + tmp[1] + tmp[2];
		visited = new boolean[sum+1][sum+1];
        
		int answer = bfs();
		System.out.println(answer);
	}
	static int bfs() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(tmp);
		while (!que.isEmpty()) {
			int[] arr = que.poll();
			if (arr[0] == arr[1] && arr[1] == arr[2]) {
				return 1;
			}
            
			for (int i = 0; i < 3; i++) {
				for (int j = i+1; j < 3; j++) {
					int min = Math.min(arr[i], arr[j]);
					int max = Math.max(arr[i], arr[j]);
					int left = sum - min - max;
					if (!visited[min][max]) {
						visited[min][max] = true;
						que.offer(new int[]{min+min, max-min, left});
					}
				}
			}
		}
		return 0;
	}
}