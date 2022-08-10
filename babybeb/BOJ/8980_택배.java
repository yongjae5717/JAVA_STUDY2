import java.io.*;
import java.util.*;

/* 이해가 잘 안감 */

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    private static class Information implements Comparable<Information> {
        
        int begin;
        int end;
        int capacity;
        
        public Information(int begin, int end, int capacity) {
            this.begin = begin;
            this.end = end;
            this.capacity = capacity;
        }
        
        @Override
        public int compareTo(Information o) {
            if (this.end == o.end) {
                return this.begin - o.begin;
            }
            return this.end - o.end;
        }
    }
    
    static int n, c, m, ans, max, spare;
    static Information[] info;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        info = new Information[m];
        capacity = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            info[i] = new Information(Integer.parseInt(st.nextToken()),
                                      Integer.parseInt(st.nextToken()),
                                      Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(info);
        System.out.print(ans);
    }
}