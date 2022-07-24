import java.io.*;
import java.util.*;

public class Main {

    static int n, m, c;
    static int[][][] dp;
    static int[] jewel;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 보석의 개수
        m = Integer.parseInt(st.nextToken()); // 가방의 크기
        c = Integer.parseInt(st.nextToken()); // 가방의 한도
        dp = new int[1 << n][m+1][c+1];

        jewel = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            jewel[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search(0, 0, c));
    }

    public static int search(int used, int bi, int remain){

        // 보석을 모두 사용했거나, 가방을 모두 사용한 경우.
        if((used == (1 << n - 1)) || bi == m)
            return 0;

        // dp에 이미 값이 있는 경우
        if(dp[used][bi][remain] != 0)
            return dp[used][bi][remain];

        // dp에 값이 없다면 보석 차례대로 탐색한다.
        for(int ji = 0; ji < n; ji++){

            // 이미 i번째 보석을 사용했다면 다음 보석으로 넘어간다.
            if((used & (1 << ji)) > 0)
                continue;

            // bi번째 가방의 남은 용량 >= ji번째 보석의 무게라면 해당 가방을 사용한다.
            if(remain >= jewel[ji]) {
                dp[used][bi][remain] = Math.max(dp[used][bi][remain], search(used | (1 << ji), bi, remain - jewel[ji]) + 1);
            }
            // bi번째 가방의 남은 용량 < ji번째 보석의 무게라면 bi + 1 가방으로 넘어간다.
            else {
                dp[used][bi][remain] = Math.max(dp[used][bi][remain], search(used, bi + 1, c));
            }
        }
        return dp[used][bi][remain];
    }
}
