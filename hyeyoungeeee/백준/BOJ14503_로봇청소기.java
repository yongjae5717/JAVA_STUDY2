package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {
    static class Point{
        int y, x, d;

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    static int N, M;
    static int[][] Map;
    static Point now;
    static int[] tx = {1, -1, 0, 0};
    static int[] ty = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        now = new Point(y, x, d);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        Map[now.y][now.x] = 2;
        answer++;
        while (true) {

            if (canNotGoAnywhere()) {
                if (backIsWall()) {
                    break;
                } else {
                    moveBack();
                    continue;
                }
            }

            if (isSpaceLeft()) {
                // 왼쪽 방향에 청소하지 않은 공간 존재 -> 그 방향으로 회전 후 한칸 이동
                move();
                Map[now.y][now.x] = 2;
                answer++;
                continue;
            } else {
                // 왼쪽 방향에 청소할 공간 x -> 그 방향으로 회전 후 처음으로
                continue;
            }
        }

        System.out.println(answer);

    }
    static boolean backIsWall() {
        int backY, backX;
        if (now.d == 0) {
            backY = now.y + 1;
            backX = now.x;
        } else if (now.d == 3) {
            backY = now.y;
            backX = now.x + 1;
        } else if (now.d == 2) {
            backY = now.y - 1;
            backX = now.x;
        } else {
            backY = now.y;
            backX = now.x - 1;
        }

        if (Map[backY][backX] == 1) {
            return true;
        }
        return false;
    }
    static boolean canNotGoAnywhere() {
        for (int i = 0; i < 4; i++) {
            if(Map[now.y + ty[i]][now.x + tx[i]] == 0) {
                return false;
            }
        }
        return true;
    }
    static void moveBack() {
        if (now.d == 0) {
            now.y += 1;
        } else if (now.d == 3) {
            now.x += 1;
        } else if (now.d == 2) {
            now.y -= 1;
        } else {
            now.x -= 1;
        }
    }

    static void move() {
        if (now.d == 0) {
            now.y -= 1;
        } else if (now.d == 3) {
            now.x -= 1;
        } else if (now.d == 2) {
            now.y += 1;
        } else {
            now.x += 1;
        }
    }

    static boolean isSpaceLeft() {
        int nextY, nextX;
        if (now.d == 0) {
            nextY = now.y;
            nextX = now.x - 1;
            now.d = 3;
        } else if (now.d == 3) {
            nextY = now.y + 1;
            nextX = now.x;
            now.d = 2;
        } else if (now.d == 2) {
            nextY = now.y;
            nextX = now.x + 1;
            now.d = 1;
        } else {
            nextY = now.y - 1;
            nextX = now.x;
            now.d = 0;
        }

        if (Map[nextY][nextX] == 0) {
            return true;
        }
        return false;
    }
}

