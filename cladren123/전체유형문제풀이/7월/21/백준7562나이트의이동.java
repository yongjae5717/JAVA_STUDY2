package studyGroup.july.july21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준7562나이트의이동 {

    static int t;
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static int starty, startx;
    static int endy, endx;

    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test = 0; test < t; test++)
        {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            starty = Integer.parseInt(st.nextToken());
            startx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endy = Integer.parseInt(st.nextToken());
            endx = Integer.parseInt(st.nextToken());

            sb.append(solution());
            sb.append("\n");

        }

        System.out.println(sb.toString());

    }

    public static int solution() {

        board = new int[n][n];
        visited = new boolean[n][n];

        Queue<dot> que = new LinkedList<>();
        que.add(new dot(starty, startx, 0));

        while(!que.isEmpty()) {

            dot d = que.poll();

            if(d.y == endy && d.x == endx)
            {
                return d.count;
            }

            for(int i = 0; i < 8; i++)
            {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(check(ny,nx))
                {
                    visited[ny][nx] = true;
                    que.add(new dot(ny,nx,d.count+1));
                }
            }
        }

        return 0;

    }

    public static boolean check(int y, int x)
    {
        if(y >= 0 && y < n && x >= 0 && x < n)
        {
            if(visited[y][x] == false)
            {
                return true;
            }
        }
        return false;
    }

    static class dot {

        int y;
        int x;
        int count;

        dot(int y, int x, int count)
        {
            this.y = y;
            this.x = x;
            this.count = count;
        }

    }


}
