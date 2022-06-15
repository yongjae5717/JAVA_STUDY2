import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, num[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        if (S == 0) {
            System.out.println(0);
            return;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = num[0];
        boolean flag = false;
        while (right < N) {
            if (sum >= S) {
                flag = true;
                int nowLength = right - left + 1;
                ans = Math.min(ans, nowLength);
                sum -= num[left];
                left++;
            } else {
                if (right == N-1) break;
                right++;
                sum += num[right];
            }
        }


        if (!flag) System.out.println(0);
        else System.out.println(ans);
    }
}
