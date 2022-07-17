package studyGroup.july.july15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class twodots16929 {

    /*

    처음의 점과 마지막에 선택한 점이 같으면 된다.
    선택한 점이 4개 이상이다.

     */

    static int n,m;
    static char[][] board;
    static int[][] visited;
    static int starty;
    static int startx;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static int flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i = 0; i < n; i++)
        {
            String temp = br.readLine();
            for(int j = 0; j < m; j++)
            {
                board[i][j] = temp.charAt(j);
            }
        }

        visited = new int[n][m];

        flag = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {

                starty = i;
                startx = j;

                visited = new int[n][m];
                dfs(i,j,1);

                if(flag == 1)
                {
                    System.out.println("Yes");
                    return;
                }


            }
        }

        System.out.println("No");

    }

    public static void dfs(int y, int x, int count)
    {

        visited[y][x] = 1;

        for(int i = 0; i < 4; i++)
        {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < n && nx >= 0 && nx < m)
            {
                if(board[y][x] == board[ny][nx] && visited[ny][nx] == 0)
                {
                    visited[ny][nx] = 1;
                    dfs(ny, nx, count + 1);
                }

                if(ny == starty && nx == startx && count >= 4)
                {
                    flag = 1;
                    return;
                }
            }
        }





    }



}
