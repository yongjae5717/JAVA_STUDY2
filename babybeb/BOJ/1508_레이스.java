import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, m, k;
    static String ans;
    static int[] track;
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        track = new int[k];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            track[i] = Integer.parseInt(st.nextToken());
        }
        
        // 이분탐색
        long start = 0;
        long end = n;
        while (start <= end) {
            long mid = (start + end) / 2;
            
            String temp = "1";
            int selectedCnt = 1;
            int lastIdx = 0;
            
            for (int i = 1; i < k; i++) {
                if (track[i] - track[lastIdx] >= mid) {
                    temp += "1";
                    lastIdx = i;
                    selectedCnt++;
                    if (selectedCnt == m) {
                        break;
                    }
                }
                else {
                    temp += "0";
                }
            }
            
            if (selectedCnt == m) {
                for (int i = temp.length(); i < k; i++) {
                    temp += "0";
                }
                start = mid + 1;
                ans = temp;
            }
            else {
                end = mid - 1;
            }
        }
        
        System.out.print(ans);
    }
}