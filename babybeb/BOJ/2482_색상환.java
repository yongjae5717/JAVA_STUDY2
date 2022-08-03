import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int k;
    static int[][] color = new int[1001][1001];

    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        for (int i = 2; i <= n; i++) {
            color[i][1] = i;
        }
        
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                color[i][j] = color[i - 2][j - 1] + color[i - 1][j];
                color[i][j] %= 1000000003;
            }
        }
        
        System.out.print(color[n][k]);
    }
}