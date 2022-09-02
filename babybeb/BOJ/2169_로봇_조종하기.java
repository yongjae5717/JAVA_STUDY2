import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m;
    static int[][] areas, d;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        areas = new int[n][m];
        d = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                areas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        d[0][0] = areas[0][0];
        
        for (int i = 1; i < m; i++) {
            d[0][i] = areas[0][i] + d[0][i - 1];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int max = -100;
                if (i >= 1 && d[i - 1][j] != 0 && d[i - 1][j] > max) {
                    max = d[i - 1][j];
                }
                if (j >= 1 && d[i][j - 1] != 0 && d[i][j - 1] > max) {
                    max = d[i][j - 1];
                }
                
                if (max != Integer.MIN_VALUE) {
                    d[i][j] = max + areas[i][j];
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                int max = -100;
                if (j < m - 1 && d[i][j + 1] != 0 && d[i][j + 1] > max) {
                    max = d[i][j + 1];
                }
                
                if (max + areas[i][j] > d[i][j]) {
                    d[i][j] = max + areas[i][j];
                }
            }
            
        }
        
        System.out.print(d[n - 1][m - 1]);
    }
}