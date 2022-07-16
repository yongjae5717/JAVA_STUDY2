package HoYoon_Lee.bj16929_TwoDots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int[] upDown = {-1, 1, 0, 0};
    private static final int[] leftRight = {0, 0, -1, 1};
    private static final String YES = "Yes";
    private static final String NO = "No";
    private static int N, M;
    private static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];

        for(int i = 0; i < N; i++)
            board[i] = br.readLine().split("");

        String result = NO;

        LOOP:
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j].matches("[A-Z]")){
                    result = findCycle(i, j, board[i][j], 1);
                    if(result.equals(YES)) break LOOP;
                }
            }
        }

        System.out.println(result);
        br.close();
    }

    private static String findCycle(int r, int c, String color, int cnt){
        if(!board[r][c].equals(color)) return NO;

        board[r][c] += cnt;
        for(int i = 0; i < 4; i++){
            int nextR = r + upDown[i];
            int nextC = c + leftRight[i];
            if(nextR < 0 || N <= nextR || nextC < 0 || M <= nextC || board[nextR][nextC].equals(color + (cnt - 1))) continue;
            if(board[nextR][nextC].matches(color + "[0-9]+")) return YES;
            String result = findCycle(nextR, nextC, color, cnt + 1);
            if(result.equals(YES)) return result;
        }
        return NO;
    }
}