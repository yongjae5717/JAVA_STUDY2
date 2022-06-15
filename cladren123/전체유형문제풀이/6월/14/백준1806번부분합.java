package studyGroup.June.june14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

투포인터

 */

public class 백준1806번부분합 {

    static int n; // 10 <= ㅜ < 100000
    static int s; // 0 < s <= 100000000
    static int[] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        board = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            board[i] = Integer.parseInt(st.nextToken());

            if(board[i] >= s)
            {
                System.out.println(1);
                return;
            }
        }

        int left = 0;
        int right = 0;
        int temp = 0;

        int answer = Integer.MAX_VALUE;

        // 투 포인터는 while문을 사용
        // 왜 <= n 으로 했을 때 통과가 되는 것인가? 끝의 도달?
        // 올바른 길이를 구하기 위해서 n+1

        while(left <= n && right <= n)
        {
            if(temp < s)
            {
                temp += board[right++];
            }
            else
            {
                temp -= board[left++];
            }

            if(temp >= s)
            {
                answer = Math.min(answer, right - left);
            }
        }

        if(answer == Integer.MAX_VALUE)
        {
            answer = 0;
        }

        System.out.println(answer);

    }

}
