import java.io.*;
import java.util.*;

/* 모르겠어요... */
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int vCnt = 0;
        boolean[] v = new boolean[6];
        Arrays.fill(v, false);
        ArrayList<Integer>[] list = new ArrayList[6];
        for (int i = 1; i <= 5; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            v[first] = true;
            v[second] = true;
            list[first].add(second);
            list[second].add(first);
        }
        for (int i = 1; i <= 5; i++) {
            if (v[i]) {
                vCnt++;
            }
        }
        
        if (n == vCnt * (vCnt - 1) / 2) {
            System.out.print(-1);
            return;
        }
        
        if (n <= 3) {
            System.out.print(0);
            return;
        }
        
        int crash = 0;
        for (int i = 1; i <= 5; i++) {
            for (Integer integer : list[i]) {
                for (int j = i + 1; j < integer; j++) {
                    for (int k = integer + 1; k <= 5; k++) {
                        if (list[j].contains(k)) {
                            crash++;
                        }
                    }
                }
            }
        }
        
        if (vCnt == 4) {
            System.out.print(1);
        } else if (crash == 5) {
            System.out.print(2);
        } else if (crash <= 3) {
            System.out.print(1);
        }
    }
}