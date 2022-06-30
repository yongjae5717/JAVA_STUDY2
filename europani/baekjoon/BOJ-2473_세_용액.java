import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int lp, mp, rp;
    static long sum = 3_000_000_001L;
    static long[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(nums);

        for (int i=0; i < N; i++) {
            int left = i+1, right = N-1;   
        
            while (left < right) {
                long subSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(subSum) < sum) {
                    sum = Math.abs(subSum);
                    lp = i;
                    mp = left;
                    rp = right;
                }
    
                if (subSum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(nums[lp] + " " + nums[mp] + " " + nums[rp]);
    }
}