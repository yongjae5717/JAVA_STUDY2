import java.io.*;
import java.util.*;

public class Main {
    static int[] fuel = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken());
            fuel[a] = b;
        }
        
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken()); 
        int P = Integer.parseInt(st.nextToken());

        System.out.println(solution(L, P));
    }

    static int solution(int L, int P) {
        int ans = 0;
        PriorityQueue<Integer> fuelQ = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < L; i++, P--) {
            if (fuel[i] != 0) {
                fuelQ.add(fuel[i]);
            }
            if (P == 0) {
                if (!fuelQ.isEmpty()) {
                    P += fuelQ.poll();
                    ans++;
                } else {
                    return -1;
                }
            }
        }
        return ans;
    }
}