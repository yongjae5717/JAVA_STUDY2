import java.util.*;
import java.io.*;

class Main {

    static int N, sum = 2_000_000_001;
    static int[] nums;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
  
    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(nums);

        int left = 0, right = N-1;
        int ln = nums[left], rn = nums[right];
      
        while (left < right) {
            if (Math.abs(nums[left] + nums[right]) < sum) {
                sum = Math.abs(nums[left] + nums[right]);
                ln = nums[left];
                rn = nums[right];
            }

            if (nums[left] + nums[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(ln + " " + rn);
    }
}