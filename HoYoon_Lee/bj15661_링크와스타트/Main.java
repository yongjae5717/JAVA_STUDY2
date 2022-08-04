package HoYoon_Lee.bj15661_링크와스타트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static int[][] abilities;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int total = 0;
        abilities = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++){
            abilities[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            total += Arrays.stream(abilities[i]).sum();
        }

        int res = findMinDiff(0, 0, total / 2);
        System.out.println((total - res) - res);

        br.close();
    }

    private static int findMinDiff(int start, int sum, final int mid){
        int result = 0;

        for(int i = start; i < N; i++){
            int tmp = sum;
            for(int j = 0; j < start; j++)
                if(visit[j]) tmp += abilities[i][j] + abilities[j][i];
            if(tmp > mid) continue;
            result = Math.max(result, tmp);
            visit[i] = true;
            result = Math.max(result, findMinDiff(i + 1, tmp, mid));
            visit[i] = false;
        }

        return result;
    }
}
