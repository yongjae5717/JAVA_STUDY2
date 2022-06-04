package studyGroup.June.june4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

public class 백준17265나의인생에는수학과함께 {

    static int n;
    static String[][] board;


    // 오른쪽이랑 아래만 이동 가능
    static int[] dy = {0,1};
    static int[] dx = {1,0};

    static Queue<dot> que;

    static int big;
    static int small;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new String[n+1][n+1];

        for(int i = 1; i <= n; i++)
        {
            String[] one = br.readLine().split(" ");

            for(int j = 1; j <= n; j++)
            {
                board[i][j] = one[j-1];
            }
        }

        big = Integer.MIN_VALUE;
        small = Integer.MAX_VALUE;

        que = new LinkedList<>();
        que.add(new dot(1,1,Integer.parseInt(board[1][1]),""));

        while(!que.isEmpty())
        {
            dot d = que.poll();

            if(d.y == n && d.x == n)
            {
                big = Math.max(big, d.number);
                small = Math.min(small, d.number);
                continue;
            }

            for(int i = 0; i < 2; i++)
            {
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];

                if(ny >= 0 && ny <= n && nx >= 0 && nx <= n)
                {

                    String s = board[ny][nx];




                    if(Character.isDigit(s.charAt(0)))
                    {


                        int num = Integer.parseInt(board[ny][nx]);
                        if(d.opr.equals(""))
                        {
                            dot newd = new dot(ny, nx, num, d.opr);
                            que.add(newd);
                        }
                        else if(d.opr.equals("+") )
                        {
                            dot newd = new dot(ny, nx, d.number + num, d.opr);
                            que.add(newd);
                        }
                        else if(d.opr.equals("-") )
                        {
                            dot newd = new dot(ny, nx, d.number - num, d.opr);
                            que.add(newd);
                        }
                        else if(d.opr.equals("*") )
                        {
                            dot newd = new dot(ny, nx,  d.number * num, d.opr);
                            que.add(newd);
                        }
                    }
                    else
                    {
                        que.add(new dot(ny, nx, d.number, board[ny][nx]));
                    }

                }
            }
        }

        System.out.println(big + " " + small);



    }


    public static class dot
    {
        int y;
        int x;
        int number;
        String opr;

        dot(int y, int x, int number, String opr)
        {
            this.y = y;
            this.x = x;
            this.number =number;
            this.opr = opr;
        }
    }


}
