import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

// 참고 코드
// https://so-cute-danu-dev.tistory.com/104
// https://barbera.tistory.com/39
public class Main {

    static Point[] list; // list[0] = 로봇청소기, 1~10 = 먼지 (최대 10개)
    static int minMove;
    static int[][] distance;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            minMove = Integer.MAX_VALUE;

            // 1줄
            StringTokenizer line = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(line.nextToken());
            int H = Integer.parseInt(line.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            char[][] map = new char[H][W]; // 인풋으로 받은 지도
            list = new Point[11]; // list[0] = 로봇청소기, 1~10 = 먼지 (최대 10개)
            int dust_cnt = 1;

            for (int i = 0; i < H; i++) {
                // 2줄
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input[j];
                    if (input[j] == 'o') { // 0번은 무조건 로봇청소기
                        list[0] = new Point(j, i);
                    } else if (input[j] == '*') {
                        list[dust_cnt++] = new Point(j, i);
                    }
                } // for j
            } // for i

            process(map, W, H, dust_cnt);
            System.out.println(minMove);
        }
    }

    static void process(char[][] map, int W, int H, int dust_cnt) {
        // 모든 거리를 저장할 2차원 배열
        distance = new int[dust_cnt + 1][dust_cnt + 1];

        // 청소기-먼지, 먼지-먼지의 모든 거리를 구해서 저장
        for (int i = 0; i < dust_cnt; i++) {
            for (int j = i + 1; j < dust_cnt; j++) {
                int res = bfs(map, W, H, list[i], list[j]);
                if (res == -1) {
                    minMove = -1;
                    return;
                }

                distance[i][j] = distance[j][i] = res;
            }
        } // for i

        boolean[] selected = new boolean[dust_cnt];

        // 순열을 통해 모든 거리 순회
        permutation(0, 0, 0, dust_cnt, selected);
    }

    static int bfs(char[][] map, int W, int H, Point src, Point dest) {
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        boolean[][] visited = new boolean[H][W];
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(src);
        visited[src.y][src.x] = true;
        map[src.y][src.x] = '.';

        int move = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) { // 거리별 탐색
                Point current = queue.remove();
                int x = current.x;
                int y = current.y;

                if (x == dest.x && y == dest.y) { // 목적지 도달
                    return move; // 움직인 횟수 반환
                }

                for (int d = 0; d < 4; d++) {
                    int next_x = x + dx[d];
                    int next_y = y + dy[d];

                    if (outRange(next_x, next_y, W, H) // 배열에서 벗어났는가?
                            || visited[next_y][next_x]
                            || map[next_y][next_x] == 'x') {
                        continue;
                    }

                    queue.add(new Point(next_x, next_y));
                    visited[next_y][next_x] = true;
                }
            } // for s

            move++;
        }

        // 도달 불가
        return -1;
    }

    static void permutation(int idx, int cnt, int sum, int dust_cnt, boolean[] selected) {
        if (cnt == dust_cnt - 1) {
            minMove = minMove < sum ? minMove : sum;
            return;
        }

        for (int i = 1; i < dust_cnt; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            permutation(i, cnt + 1, sum + distance[idx][i], dust_cnt, selected);
            selected[i] = false;
        }
    }

    static boolean outRange(int next_x, int next_y, int w, int h) {
        return next_x < 0 || next_y < 0 || next_x >= w || next_y >= h;
    }
}