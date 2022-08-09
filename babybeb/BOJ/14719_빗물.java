import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int h, w, ans = 0;
    static int[] block;

    public static void main(String[] args) throws IOException {
        
        // 입력
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        block = new int[w];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i < w - 1; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, block[j]);
            }
            for (int j = i + 1; j < w; j++) {
                rightMax = Math.max(rightMax, block[j]);
            }
            if (Math.min(leftMax, rightMax) - block[i] <= 0) {
                continue;
            }
            ans += Math.min(leftMax, rightMax) - block[i];
        }
        
        System.out.print(ans);
    }
}