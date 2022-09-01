import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m;
    static int[][] maze, d;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        d = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        d[0][0] = maze[0][0];
        for (int i = 1; i < m; i++) {
            d[0][i] = d[0][i - 1] + maze[0][i];
        }
        for (int i = 1; i < n; i++) {
            d[i][0] = d[i - 1][0] + maze[i][0];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                d[i][j] =
                    Math.max(Math.max(d[i - 1][j - 1], d[i - 1][j]), d[i][j - 1]) + maze[i][j];
            }
        }
        
        System.out.print(d[n - 1][m - 1]);
    }
}