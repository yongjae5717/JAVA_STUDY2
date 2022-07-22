import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N;
    static int l;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dx = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
    static int kr, kc, er, ec;

    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < N; i++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];
            String[] knightInfo = br.readLine().split(" ");
            kr = Integer.parseInt(knightInfo[0]);
            kc = Integer.parseInt(knightInfo[1]);

            String[] endInfo = br.readLine().split(" ");
            er = Integer.parseInt(endInfo[0]);
            ec = Integer.parseInt(endInfo[1]);
            sb.append(getMoveNum(er, ec)).append("\n");

        }
        System.out.println(sb);

    }

    public static int getMoveNum(int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            r = pos[0];
            c = pos[1];

            if (r == kr && c == kc) break;

            for (int i = 0; i < 8; i++) {
                int posY = r + dy[i];
                int posX = c + dx[i];

                if (posY < 0 || posY >= l || posX < 0 || posX >= l || map[posY][posX] != 0) continue;

                map[posY][posX] = map[r][c] + 1;
                q.offer(new int[]{posY, posX});
            }
        }

        return map[kr][kc];
    }
}