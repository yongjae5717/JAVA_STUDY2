import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, c;
    static long ans;
    static long[] wifi;
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        wifi = new long[n];
        
        for (int i = 0; i < n; i++) {
            wifi[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(wifi);
        
        // 이분탐색
        long start = 0;
        long end = (wifi[n - 1] - wifi[0]) / (c - 1) + 1;
        while (start <= end) {
            long mid = (start + end) / 2; // 두 공유기 사이 거리
            
            int selectedCnt = 1;
            int lastIdx = 0;
            
            for (int i = 1; i < n; i++) {
                if (wifi[i] - wifi[lastIdx] >= mid) { // 두 공유기 사이의 거리가 mid 이상인지 확인하기
                    lastIdx = i;
                    selectedCnt++;
                    
                    if (selectedCnt == c) { // c개를 다 설치할 수 있는 경우
                        break;
                    }
                }
            }
            
            if (selectedCnt == c) { // c개를 다 설치할 수 있는 경우에는 각 wifi 사이의 거리를 더 넓혀본다
                ans = mid;
                start = mid + 1;
            } else { // c개를 다 설치할 수 없는 경우에는 각 wifi 사이의 거리를 더 좁혀본다
                end = mid - 1;
            }
        }
        
        System.out.print(ans);
    }
}