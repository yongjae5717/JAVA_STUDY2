package HoYoon_Lee.bj2933_미네랄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] directions = {1, -1};
    private static final int[] upDown = {1, -1, 0, 0};
    private static final int[] leftRight = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] cave = new String[R][C];

        for(int i = 0; i < R; i++)
            cave[i] = br.readLine().split("");

        int N = Integer.parseInt(br.readLine());
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < N; i++){
            int direction = directions[i % 2];
            for(int j = direction > 0? 0 : C; 0 < j && j < C; j += direction){
                if(cave[heights[i]][j].equals(".")) continue;
                cave[heights[i]][j] = ".";

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(heights[i]);
                queue.offer(j);
                while (!queue.isEmpty()){
                    int x = queue.poll();
                    int y = queue.poll();

                    if(x < 0 || cave[x - 1][y].equals("."))

                    for(int k = 0; k < 4; k++){
                        int nextX = x + upDown[k];
                        int nextY = y + leftRight[k];

                        if(nextX < 0 || R < nextX || nextY < 0 || C < nextY) continue;

                    }
                }

                break;
            }
        }

        br.close();
    }
}
