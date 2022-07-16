import java.util.*;

/*

ㄷ 부분이 모두 걸린다
사이즈를 2배로 늘려라..

*/


class Solution {

    static int n;
    static int h,w;
    static int[][] board;
    static int[][] visited;

    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    static int[] newdx = {1,0,-1,0};
    static int[] newdy = {0,-1,0,1};
    static int[][] newVisited;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        n = rectangle.length;

        h = 0;
        w = 0;


        // 좌측 하단, 우측 상단

        for(int i = 0; i < n; i++)
        {
            h = Math.max(h, rectangle[i][3]);
            w = Math.max(w, rectangle[i][2]);
        }

        h = h * 2;
        w = w * 2;

        board = new int[h+2][w+2];


        for(int i = 0; i < n; i++)
        {
            line(rectangle[i]);
        }

        visited = new int[h+2][w+2];

        getLine();

//         for(int i = 0; i < h+2; i++)
//         {
//             System.out.println(Arrays.toString(board[i]));
//         }



        newVisited = new int[h+2][w+2];
        Queue<newDot> que = new LinkedList<>();
        que.add(new newDot(characterY * 2, characterX * 2, 0));
        newVisited[characterY * 2][characterX * 2] = 1;

        while(!que.isEmpty())
        {
            newDot d = que.poll();

            // System.out.println(d.y + " " + d.x + " " + d.count);

            if(d.y == itemY * 2 && d.x == itemX * 2)
            {
                answer = d.count / 2;
                break;
            }

            for(int i = 0; i < 4; i++)
            {
                int ny = d.y + newdy[i];
                int nx = d.x + newdx[i];

                if(ny >= 0 && ny < h+2 && nx >= 0 && nx < w+2)
                {
                    if(newVisited[ny][nx] == 0 && board[ny][nx] == 9)
                    {
                        newVisited[ny][nx] = 1;
                        board[ny][nx] = d.count + 1;
                        que.add(new newDot(ny,nx,d.count + 1));
                    }

                }
            }
        }


        // for(int i = 0; i < h+2; i++)
        // {
        //     System.out.println(Arrays.toString(board[i]));
        // }





        return answer;
    }

    public class newDot
    {
        int y;
        int x;
        int count;

        newDot(int y, int x, int count)
        {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public void getLine()
    {
        Queue<dot> que = new LinkedList<>();
        que.add(new dot(0,0));
        visited[0][0] = 1;

        while(!que.isEmpty())
        {
            dot d = que.poll();

            for(int i = 0; i < 8; i++)
            {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(ny >= 0 && ny < h+2 && nx >= 0 && nx < w+2)
                {
                    if(board[ny][nx] == 0 && visited[ny][nx] == 0)
                    {
                        visited[ny][nx] = 1;
                        que.add(new dot(ny, nx));
                    }
                    else if(board[ny][nx] == 1 && visited[ny][nx] == 0)
                    {
                        visited[ny][nx] = 1;
                        board[ny][nx] = 9;
                    }
                }
            }
        }

    }

    public class dot
    {
        int y;
        int x;

        dot(int y, int x)
        {
            this.y = y;
            this.x = x;
        }
    }




    public void line(int[] rect)
    {
        int x1 = rect[0] * 2;
        int y1 = rect[1] * 2;
        int x2 = rect[2] * 2;
        int y2 = rect[3] * 2;

        for(int i = y1; i <= y2; i++)
        {
            for(int j = x1; j <= x2; j++)
            {
                board[i][j] = 1;
            }
        }

    }


}