package HoYoon_Lee.bj2169_로봇조종하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int[] upDown = {1, 0, 0};
    private static final int[] leftRight = {0, -1, 1};
    private static int N;
    private static int M;
    private static int[][] values;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        values = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < M; i++)
            values[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visit[0][0] = true;
        System.out.println(getMax(0, 0, values[0][0]));

        br.close();
    }

    private static int getMax(int r, int c, int sum){
        int max = Integer.MIN_VALUE;
        if(r == N - 1 && c == M - 1) return sum;

        for(int i = 0; i < 3; i++) {
            int nextR = r + upDown[i];
            int nextC = c + leftRight[i];
            if(nextR < 0 || N <= nextR || nextC < 0 || M <= nextC || visit[nextR][nextC]) continue;
            visit[nextR][nextC] = true;
            max = Math.max(max, getMax(nextR, nextC, sum + values[nextR][nextC]));
            visit[nextR][nextC] = false;
        }
        return max;
    }
}
