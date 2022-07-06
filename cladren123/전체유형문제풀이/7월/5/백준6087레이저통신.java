package studyGroup.july.july5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준6087레이저통신 {

    static int w,h;
    static char[][] map;
    static int[][] visit;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static Node start, end;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        visit = new int[h][w];

        for(int i = 0; i < h; i++)
        {
            Arrays.fill(visit[i], w * h);
        }


        int flag = 0;

        for(int i = 0; i < h; i++)
        {
            String temp = br.readLine();
            for(int j = 0; j < w; j++)
            {
                map[i][j] = temp.charAt(j);

                if(map[i][j] == 'C')
                {
                    if(flag == 0)
                    {
                       start = new Node(i,j,0,4);
                       flag = 1;
                    }
                    else
                    {
                       end = new Node(i,j,0,4);
                    }
                }
            }
        }

        int answer = bfs();
        System.out.println(answer);


    }

    public static int bfs()
    {
        Queue<Node> que = new PriorityQueue<>();

        visit[start.y][start.x] = 0;
        que.add(start);

        Node node;

        while (!que.isEmpty()) {
            node = que.poll();

            if(node.y == end.y && node.x == end.x)
            {
                return node.cost;
            }

            for(int i = 0; i < 4; i++)
            {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(!check(ny, nx) || map[ny][nx] == '*') continue;

                // 방향이 같은 경우
                if(node.dir == i || node.dir == 4)
                {
                    if(visit[ny][nx] >= node.cost)
                    {
                        visit[ny][nx] = node.cost;
                        que.add(new Node(ny, nx, node.cost, i));
                    }
                }

                // 방향이 다른 경우
                else
                {
                    if(visit[ny][nx] >= node.cost + 1)
                    {
                        visit[ny][nx] = node.cost + 1;
                        que.add(new Node(ny, nx, node.cost + 1, i));
                    }
                }

            }
        }

        return -1;

    }

    public static boolean check(int y, int x)
    {
        if(y >= 0 && y < h && x >= 0 && x < w)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    // 우선순위가 적용된 클래스. 거울을 적게 쓴 순서가 먼저 나온다.
    public static class Node implements Comparable<Node>
    {
        int y;
        int x;
        int cost;
        int dir;

        Node(int y, int x, int cost, int dir)
        {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

}
