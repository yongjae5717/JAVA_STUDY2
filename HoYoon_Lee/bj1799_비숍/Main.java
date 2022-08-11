package HoYoon_Lee.bj1799_비숍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
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

        int result = findMaxBishop(0, 0);
        result += findMaxBishop(0, 1);
        System.out.println(result);

        br.close();
    }

    private static int findMaxBishop(int r, int c){
        if(c >= N){
            if(++r == N) return 0;
            if(N % 2 == 0) c = (c == N? 1 : 0);
            else c -= N;
        }

        int max = 0;
        int nextR = r;
        int nextC = c + 2;

        if(isPossible(r, c)){
            visit[r][c] = true;
            max = findMaxBishop(nextR, nextC) + 1;
            visit[r][c] = false;
        }
        max = Math.max(max, findMaxBishop(nextR, nextC));
        return max;
    }

    private static boolean isPossible(int r, int c){
        if(board[r][c] == 0) return false;

        for(int i = r - 1, term = 1; i >= 0; i--, term++){
            if((c >= term && visit[i][c - term])
                    || (c + term < N && visit[i][c + term]))
                return false;
        }
        return true;
    }
}
