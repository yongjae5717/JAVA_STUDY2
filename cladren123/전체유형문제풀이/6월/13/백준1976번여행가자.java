package studyGroup.June.june13;

import java.util.*;
import java.lang.*;
import java.io.*;

/*

유니온파인드드

반례
4
4
0 0 0 1
0 0 1 0
0 1 0 1
1 0 1 0
3 1 2 4

 */

public class 백준1976번여행가자 {

    static int n; // 도시의 수
    static int m; // 여행 계획에 속한 도시의 수
    static int[][] board;
    static int[] trip;

    static int[] parent;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];

        m = Integer.parseInt(br.readLine());
        trip = new int[m];



        for(int i = 1; i <= n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++)
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++)
        {
            trip[i] = Integer.parseInt(st.nextToken());
        }


        // 유니온 파인드
        parent = new int[n+1];
        for(int i = 1; i <= n; i++)
        {
            parent[i] = i;
        }
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(board[i][j] == 1)
                {
                    union(i,j);
                }
            }
        }

//        for(int i = 0; i <= n; i++)
//        {
//            System.out.println(Arrays.toString(board[i]));
//        }
//        System.out.println();
//        System.out.println(Arrays.toString(parent));

        // 정답 출력
        if(m <= 1)
        {
            System.out.println("YES");
            return;
        }

        int check = find(trip[0]);

        for(int i = 1; i < m; i++)
        {
            if(check != find(trip[i]))
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }



    static int find(int x)
    {
        if(parent[x] == x)
        {
            return x;
        }

        int y = find(parent[x]);
        parent[x] = y;
        return y;
    }

    static void union(int x, int y)
    {
        x = find(x); // x를 이용하면 된다 굳이 findx를 이용할 필요가 없다.
        y = find(y);

        if(x != y)
        {
            if(x < y)
            {
                parent[y] = x;
            }
            else
            {
                parent[x]  = y;
            }
        }

        return;
    }




}
