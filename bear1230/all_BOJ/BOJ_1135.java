import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int depth[];
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}      
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if(i==0) continue;
			list.get(p).add(i);
		}
		
		int dfs = dfs(0);
		System.out.println(dfs);
	}

	private static int dfs(int now) {
		if(list.get(now).size()==0) return 0;
		
		Integer[] temparray = new Integer[list.get(now).size()];
		for (int i = 0; i < list.get(now).size(); i++) {
			Integer next = list.get(now).get(i);
			temparray[i] = dfs(next);
		}
		
		Arrays.sort(temparray, Collections.reverseOrder());
		
		int max = 0;
		for (int i = 0; i < temparray.length; i++) {
			max = Math.max(max, temparray[i]+(i+1));
		}

		return max;
	}
}