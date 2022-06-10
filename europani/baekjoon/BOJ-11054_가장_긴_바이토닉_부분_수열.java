import java.util.*;
import java.io.*;

class Main {
  
    static int N;
    static Integer[] nums;
    static int[] l_dp, r_dp, bitony;

    static void input() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
          .map(Integer::parseInt).toArray(Integer[]::new);

        l_dp = new int[N];
        Arrays.fill(l_dp, 1);
        r_dp = new int[N];
        Arrays.fill(r_dp, 1);
        bitony = new int[N];
    }

    static void left() {
        for (int i = 0; i < N; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    l_dp[i] = Math.max(l_dp[j]+1, l_dp[i]);
                }  
            }
        }
    }

    static void right() {
        for (int i = N-1; i >= 0; i--) {
            for (int j = i+1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    r_dp[i] = Math.max(r_dp[j]+1, r_dp[i]);
                }  
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        left();
        right();
        int result = 0;

        for (int i= 0; i < N; i++) {
            bitony[i] = l_dp[i] + r_dp[i] - 1;
            result = Math.max(bitony[i], result);
        }
        System.out.println(result);
    }
}
