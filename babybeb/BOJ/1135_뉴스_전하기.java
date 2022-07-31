import java.io.*;
import java.util.*;

/* tree + dfs 까지는 알겠는데 dfs 구현을 어떻게 해야 할지 모르겠다 */

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] list;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i <= n; i++) {
            list[Integer.parseInt(st.nextToken())].add(i);
        }
        
        dfs();
        
    }
}