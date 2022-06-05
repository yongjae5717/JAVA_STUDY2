package day2206.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17265_나의인생에는수학과함께 {

    static class Point {
        int r, c, num;
        char op;

        public Point(int r, int c, int num, char op) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.op = op;
        }
    }

    final static int dr[] = {1, 0}, dc[] = {0, 1};
    static int N;
    static char map[][];
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        bfs();
        System.out.println(max + " " + min);
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, map[0][0] - '0', ' '));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.r == N - 1 && p.c == N - 1) {
                min = Math.min(min, p.num);
                max = Math.max(max, p.num);
                continue;
            }

            for (int i = 0; i < 2; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if (map[nr][nc] == '+' || map[nr][nc] == '-' || map[nr][nc] == '*') {
                    q.offer(new Point(nr, nc, p.num, map[nr][nc]));
                    continue;
                }

                q.offer(new Point(nr, nc, operate(p.num, p.op, map[nr][nc]), ' '));
            }
        }
    }

    private static int operate(int num, char op, char c) {
        switch (op) {
            case '+':
                return num + (c - '0');
            case '-':
                return num - (c - '0');
            case '*':
                return num * (c - '0');
        }
        return -1;
    }
}
