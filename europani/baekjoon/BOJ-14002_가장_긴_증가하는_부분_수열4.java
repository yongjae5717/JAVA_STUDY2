import java.util.*;
import java.io.*;

class Main {

    static int N, len = 1;
    static int[] nums, dp;
    static Stack<Integer> stack;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        dp = new int[N];
        Arrays.fill(dp, 1);
        stack = new Stack<>();
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();

        for (int i=0; i < N; i++) {
            for (int j=i-1; j >= 0; j--) {
                if (nums[j] < nums[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                }
            }
            len = Math.max(dp[i], len);
        }
        System.out.println(len);
      
        int i = N-1;
        while (len > 0) {
            if (dp[i] == len) {
                stack.push(nums[i]);
                len--;
            }
            i--;
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}