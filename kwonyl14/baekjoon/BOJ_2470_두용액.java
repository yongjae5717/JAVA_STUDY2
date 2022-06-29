import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, num[], ans[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        ans = new int[2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int start = 0;
        int end = N-1;
        int minValue = Integer.MAX_VALUE;
        while (end > start) {
            int sum = num[start] + num[end];

            if (sum == 0) {
                ans[0] = num[start];
                ans[1] = num[end];
                break;
            }

            if (Math.abs(sum) < minValue) {
                minValue = Math.abs(sum);
                ans[0] = num[start];
                ans[1] = num[end];
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }

        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
