package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12886_돌그룹 {
    static int A, B, C;
    static boolean[][] visited = new boolean[1501][1501];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BOJ12886_돌그룹/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int sum = A + B + C;
        if(sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        Queue<Stone> q = new LinkedList<>();
        q.offer(new Stone(A, B, C));
        visited[A][B] = true;

        while (!q.isEmpty()) {
            Stone now = q.poll();
            if(now.a == now.b && now.b == now.c){
                System.out.println(1);
                return;
            }
            int nx, ny;
            if (now.a != now.b) {
                if (now.a < now.b) {
                    nx = now.a * 2;
                    ny = now.b - now.a;
                } else {
                    nx = now.b * 2;
                    ny = now.a - now.b;
                }
                if(!visited[nx][ny]){
                    q.offer(new Stone(nx, ny, sum - nx - ny));
                    visited[nx][ny] = true;
                }
            }
            if (now.b != now.c) {
                if (now.b < now.c) {
                    nx = now.b * 2;
                    ny = now.c - now.b;
                } else {
                    nx = now.c * 2;
                    ny = now.b - now.c;
                }
                if(!visited[nx][ny]){
                    q.offer(new Stone(nx, ny, sum - nx - ny));
                    visited[nx][ny] = true;
                }
            }
            if (now.a != now.c) {
                if (now.a < now.c) {
                    nx = now.a * 2;
                    ny = now.c - now.a;
                } else {
                    nx = now.c * 2;
                    ny = now.a - now.c;
                }
                if(!visited[nx][ny]){
                    q.offer(new Stone(nx, ny, sum - nx - ny));
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(0);

    }
    static class Stone{
        int a, b, c;

        public Stone(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

