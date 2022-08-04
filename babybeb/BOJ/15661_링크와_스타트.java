import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int n, answer = Integer.MAX_VALUE;
    static int[][] s;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int startTeamSize = 1; startTeamSize <= n - 1; startTeamSize++) {
            visited = new boolean[n + 1];
            func(1, startTeamSize, 0);
        }
        
        System.out.println(answer);
    }
    
    private static void func(int lastIdx, int startTeamSize, int k) {
        
        if (startTeamSize == k) {
            int start = 0, link = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    if (visited[i] && visited[j]) {
                        start += s[i][j] + s[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += s[i][j] + s[j][i];
                    }
                }
            }
            
            if (Math.abs(start - link) < answer) {
                answer = Math.abs(start - link);
            }
            
            return;
        }
        
        for (int i = lastIdx; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                func(i, startTeamSize, k + 1);
                visited[i] = false;
            }
        }
    }
}