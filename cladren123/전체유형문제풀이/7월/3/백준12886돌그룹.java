package studyGroup.july.july3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준12886돌그룹 {

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 ~ 500
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        stone stone = new stone(a,b,c);
        visited = new boolean[1501][1501];

        if(bfs(stone))
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }

    }

    static boolean bfs(stone st)
    {
        int hap = st.a + st.b + st.c;

        // 3으로 안 나우어 떨어지면 false를 반환
        if(hap % 3 != 0)
        {
            return false;
        }

        Queue<stone> que = new LinkedList<>();
        que.add(st);
        visited[st.a][st.b] = true;

        while(!que.isEmpty())
        {
            stone s = que.poll();

            if(s.a == s.b && s.b == s.c)
            {
                return true;
            }

            if(s.a != s.b)
            {
                int na = s.a > s.b ? s.a - s.b : s.a + s.a;
                int nb = s.b > s.a ? s.b - s.a : s.b + s.b;

                if(visited[na][nb] == false)
                {
                    que.add(new stone(na, nb, s.c));
                    visited[na][nb] = true;
                }

            }

            if(s.a != s.c)
            {
                int na = 0;
                int nc = 0;
                if(s.a > s.c)
                {
                    na = s.a - s.c;
                    nc = s.c + s.c;
                }
                else
                {
                    na = s.a + s.a;
                    nc = s.c - s.a;
                }

                if(visited[na][nc] == false)
                {
                    que.add(new stone(na, s.b, nc));
                    visited[na][nc] = true;
                }
            }

            if(s.b != s.c)
            {
                int nb, nc;
                if(s.b > s.c)
                {
                    nb = s.b - s.c;
                    nc = s.c + s.c;
                }
                else
                {
                    nb = s.b + s.b;
                    nc = s.c - s.b;
                }

                if(visited[nb][nc] == false)
                {
                    que.add(new stone(s.a, nb, nc));
                    visited[nb][nc] = true;
                }
            }
        }

        return false;

    }



    static class stone
    {
        int a;
        int b;
        int c;

        stone(int a, int b, int c)
        {
            this.a = a ;
            this.b = b;
            this.c = c;
        }
    }

}
