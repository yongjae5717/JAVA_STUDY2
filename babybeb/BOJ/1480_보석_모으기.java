/* 실패 코드입니다 */

import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, c;
    static int[] jewel;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        jewel = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            jewel[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.print(dfs(0, 0, 0));
    }
    
    private static int dfs(int bag, int weight, int path) {
        
    }
}