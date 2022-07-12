package HoYoon_Lee.bj1103_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static String[] board;
    private static final Map<String, Integer> dp = new HashMap<>();
    private static final int[] upDown = {1, -1, 0, 0};
    private static final int[] leftRight = {0, 0, 1, -1};
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N];

        for(int i = 0; i < N; i++)
            board[i] = br.readLine();
        br.close();

        System.out.println(move(0, 0, ""));
    }

    private static int move(int x, int y, String record){
        if(x < 0 || N <= x || y < 0 || M <= y || board[x].charAt(y) == 'H') return 0;

        int max = 0;
        int number = Character.getNumericValue(board[x].charAt(y));
        for(int i = 0; i < 4; i++) {
            int nextX = x + number * upDown[i];
            int nextY = y + number * leftRight[i];

            String route = "(" + x + ", " + y + "->" + nextX + ", " + nextY + ")";

            int res;
            if(record.matches(".*" + route + ".*")) res = -1;
            else if(dp.containsKey(route)) res = dp.get(route);
            else res = move(nextX, nextY, record + route);

            dp.put(route, res);
            if(res == -1) return -1;
            max = Math.max(max, res);
        }
        return max + 1;
    }
}
