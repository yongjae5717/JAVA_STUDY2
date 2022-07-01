package studyGroup.June.june30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
https://bcp0109.tistory.com/56

지정된 용액 + 두 용액으로 계산
 */

public class 백준2473세용액 {

    static int n;
    static long[] board;
    static long check;
    static long[] answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        board = new long[n];
        answer = new long[3];

        for(int i = 0; i < n; i++)
        {
            board[i] = Long.parseLong(st.nextToken());
        }

        check = 3000000000L; // 41%의 원인 Integer.MAX_VALUE

        Arrays.sort(board);

        for(int i = 0; i < n-2; i++)
        {
            binarySearch(i);
        }

        Arrays.sort(answer);

        for (long i : answer) {
            System.out.print(i + " ");
        }



    }

    public static void binarySearch(int index)
    {
        int left = index+1;
        int right = n-1;

        long sum = 0;
        long gap = 0;


        while(left < right)
        {
            sum = board[left] + board[right] + board[index];
            gap = Math.abs(sum);

            if(check > gap)
            {
                check = gap;
                answer[0] = board[left];
                answer[1] = board[index];
                answer[2] = board[right];
            }

            if(sum > 0)
            {
                right--;
            }
            else
            {
                left++;
            }

        }

    }

}
