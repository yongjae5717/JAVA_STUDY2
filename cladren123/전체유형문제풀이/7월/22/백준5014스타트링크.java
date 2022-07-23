package studyGroup.july.july22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준5014스타트링크 {

    static int f,s,g,u,d;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken()); // 전체 층
        s = Integer.parseInt(st.nextToken()); // 현재 위치
        g = Integer.parseInt(st.nextToken()); // 목적지

        int[] dir = new int[2];
        u = Integer.parseInt(st.nextToken()); // 업
        d = Integer.parseInt(st.nextToken()); // 다운

        dir[0] = u;
        dir[1] = d * -1;


        int[] board = new int[f+1];
        Arrays.fill(board, -1);

        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        board[s] = 0;

        int answer = -2;

        while (!que.isEmpty())
        {
            Integer p = que.poll();

            if(p == g)
            {
                answer = board[p];
                break;
            }

            for(int i = 0; i < 2; i++)
            {
                int np = p + dir[i];

                if(np >= 1 && np < f+1 && board[np] == -1)
                {
                    board[np] = board[p] + 1;
                    que.add(np);
                }
            }
        }

        if(answer == -2)
        {
            System.out.println("use the stairs");
            return;
        }

        System.out.println(answer);
        return;

    }

}
