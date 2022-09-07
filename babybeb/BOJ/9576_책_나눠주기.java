import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    
    static public class Pair implements Comparable<Pair> {
        
        int a, b;
        
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.a == o.a) {
                if (this.b == o.b) {
                    return 0;
                }
                return this.b - o.b;
            }
            return this.a - o.a;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int t, n, m;
    static Pair[] pairs;
    
    public static void main(String[] args) throws IOException {
        
        t = parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int curBookNum = 1;
            st = new StringTokenizer(br.readLine());
            n = parseInt(st.nextToken());
            m = parseInt(st.nextToken());
            pairs = new Pair[m];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                pairs[j] = new Pair(parseInt(st.nextToken()), parseInt(st.nextToken()));
            }
            Arrays.sort(pairs);
            
            int cnt = 0;
            for (int j = 0; j < pairs.length; j++) {
                for (; curBookNum <= n; curBookNum++) {
                    if (curBookNum >= pairs[j].a && curBookNum <= pairs[j].b) {
                        curBookNum++;
                        cnt++;
                        break;
                    }
                }
            }
            
            System.out.println(cnt);
        }
    }
}