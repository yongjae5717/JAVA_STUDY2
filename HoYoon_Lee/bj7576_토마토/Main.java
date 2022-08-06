package HoYoon_Lee.bj7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[] upDown = {1, -1, 0, 0};
    private static final int[] leftRight = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[N][];
        boolean[][] visit = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++)
            box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(box[i][j] == 1){
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        int cnt = -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int[] coordi = queue.poll();

                for(int m = 0; m < 4; m++){
                    int r = coordi[0] + upDown[m];
                    int c = coordi[1] + leftRight[m];

                    if(r < 0 || N <= r || c < 0 || M <= c || visit[r][c]) continue;
                    visit[r][c] = true;
                    if(box[r][c] == -1) continue;
                    if(box[r][c] == 0){
                        box[r][c] = 1;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            cnt++;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visit[i][j] && box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }
}
