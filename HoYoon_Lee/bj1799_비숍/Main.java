package HoYoon_Lee.bj1799_비숍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int[] leftRight = {1, -1};

    private static int N;
    private static int[][] board;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findMaxBishop(0, 0));

        br.close();
    }

    private static int findMaxBishop(int r, int c){
        int max = 0;
        int nextX = r;
        int nextY = c + 1;

        if(nextY == N){
            nextX++;
            nextY = 0;
        }

        if(isPossible(r, c)){
            visit[r][c] = true;
            max = findMaxBishop(nextX, nextY) + 1;
            visit[r][c] = false;
        }
        max = Math.max(max, findMaxBishop(nextX, nextY));
        return max;
    }

    private static boolean isPossible(int r, int c){
        if(board[r][c] == 0) return false;

        int term = 0;
        for(int i = r; i >= 0; i--, term++){
            if((c >= term && visit[i][c - term]) || (c + term < N && visit[i][c + term]))
                return false;
        }
        return true;
    }
}
