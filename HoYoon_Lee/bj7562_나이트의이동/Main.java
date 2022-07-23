package HoYoon_Lee.bj7562_나이트의이동;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] upDown = {2, 1, -1, -2, 2, 1, -1, -2};
    private static final int[] leftRight = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int l = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] dest = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start[0]);
            queue.offer(start[1]);

            boolean[][] visit = new boolean[l][l];
            visit[start[0]][start[1]] = true;

            int cnt = 0;
            LOOP:
            while (!queue.isEmpty()){
                int size = queue.size() / 2;
                while (size-- > 0) {
                    int x = queue.poll();
                    int y = queue.poll();
                    if(x == dest[0] && y == dest[1]) break LOOP;
                    for (int i = 0; i < 8; i++) {
                        int nextX = x + upDown[i];
                        int nextY = y + leftRight[i];
                        if (nextX < 0 || l <= nextX || nextY < 0 || l <= nextY || visit[nextX][nextY]) continue;
                        visit[nextX][nextY] = true;
                        queue.offer(nextX);
                        queue.offer(nextY);
                    }
                }
                cnt++;
            }
            bw.write(cnt + "\n");
        }

        br.close();
        bw.close();
    }
}
