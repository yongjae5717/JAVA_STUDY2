package HoYoon_Lee.bj12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int WEIGHT = 0, VALUE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" ")), k = Integer.parseInt(st.nextToken());
        int[][] carry = new int[n + 1][k + 1], wv = new int[n + 1][];

        for(int i = 1; i <= n; i++)
            wv[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                carry[i][j] = carry[i - 1][j];
                if(wv[i][0] <= j)
                    carry[i][j] = Math.max(carry[i][j], wv[i][1] + carry[i - 1][j - wv[i][0]]);
            }
        }

        System.out.println(carry[n][k]);

        br.close();
    }
}