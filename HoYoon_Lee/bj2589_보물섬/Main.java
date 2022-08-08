package HoYoon_Lee.bj2589_보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final String LAND = "L";
    private static final String KEY_FORM = "(%d, %d) -> (%d, %d)";
    private static final int[] upDown = {-1, 1, 0, 0};
    private static final int[] leftRight = {0, 0, -1, 1};

    private static int N;
    private static int M;
    private static String[][] treasureMap;
    private static boolean[][] visit;
    private static Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 0;
        treasureMap = new String[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) treasureMap[i] = br.readLine().split("");

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(treasureMap[i][j].equals(LAND)){
                     for(int x = 0; x < N; x++){
                         for(int y = 0; y < M; y++){
                             if(i == x && j == y) continue;
                             answer = Math.max(answer, getMinRoute(i, j, x, y));
                         }
                     }
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static int getMinRoute(int startR, int startC, final int endR, final int endC) {
        if(startR == endR && startC == endC) return 1;

        String key = String.format(KEY_FORM, startR, startC, endR, endC);
        if(dp.containsKey(key))
            return dp.get(key);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            int nextR = startR + upDown[i];
            int nextC = startC + leftRight[i];
            if(nextR < 0 || N <= nextR || nextC < 0 || M <= nextC) continue;
            if(visit[nextR][nextC]) continue;
            visit[nextR][nextC] = true;
            int res = getMinRoute(nextR, nextC, endR, endC);
            visit[nextR][nextC] = false;
            if(res != -1) min = Math.min(min, res);
        }
        if(min == Integer.MAX_VALUE) return -1;
        dp.put(key, min);
        return min + 1;
    }
}
