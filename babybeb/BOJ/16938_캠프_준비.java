import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, l, r, x, ans;
    static int[] problems;
    static int[] arr = new int[15];
    
    public static void main(String[] args) throws IOException {
        
        // 입력, 초기화
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        
        problems = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            problems[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(problems);
        
        for (int i = 2; i <= n; i++) {
            func(0, i, -1);
        }
    
        System.out.print(ans);
    }
        
    
    private static void func(int k, int cnt, int lastIdx) {
        
        if (k == cnt) {
            int sum = 0;
            for (int i = 0; i < cnt; i++) {
                sum += arr[i];
            }
            if (arr[cnt - 1] - arr[0] >= x && sum >= l && sum <= r) {
                ans++;
            }
            return;
        }
        
        for (int i = lastIdx + 1; i < n; i++) {
            arr[k] = problems[i];
            func(k + 1, cnt, i);
        }
    }
}