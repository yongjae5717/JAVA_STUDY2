public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            dp[i][1] = i;
        }

        for(int i = 4; i <= N; i++) {
            for(int j = 2; j <= N / 2; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % 1_000_000_003;
            }
        }

        System.out.println(dp[N][K]);
    }
}
