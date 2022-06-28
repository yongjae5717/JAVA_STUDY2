public class Main {
    static int N;
    static int[][][] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sum = new int[N+1][3][2];
        int answer = 1000000;
        for (int i = 1; i < N + 1; i++) {
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);
            int max1 = Integer.max(sum[i - 1][0][0], sum[i - 1][1][0]);
            int max2 = Integer.max(sum[i - 1][1][0], sum[i - 1][2][0]);
            int max3 = Integer.max(max1, max2);
            int min1 = Integer.min(sum[i - 1][0][1], sum[i - 1][1][1]);
            int min2 = Integer.min(sum[i - 1][1][1], sum[i - 1][2][1]);
            int min3 = Integer.min(min1, min2);

            sum[i][0][0] = max1 + a;
            sum[i][0][1] = min1 + a;
            sum[i][2][0] = max2 + c;
            sum[i][2][1] = min2 + c;
            sum[i][1][0] = max3 + b;
            sum[i][1][1] = min3 + b;

        }
        int max = -1;
        int min = 9000000;
        for(int i=0; i<3; i++){
             max = Integer.max(max,sum[N][i][0]);
             min = Integer.min(min,sum[N][i][1]);
        }

        System.out.println(max+" "+min);
    }
}