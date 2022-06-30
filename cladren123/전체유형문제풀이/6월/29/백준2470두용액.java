package studyGroup.June.june29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//  https://maivve.tistory.com/129

public class 백준2470두용액 {

    static int n;
    static int[] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
        {
            board[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);

        int left = 0;
        int right = n - 1;

        int gap = Integer.MAX_VALUE;
        int temp = 0;
        int sum = 0;

        int answer1 = 0;
        int answer2 = 0;

        while(left < right)
        {
            sum = board[left] + board[right];
            temp = Math.abs(sum);

            if(temp < gap)
            {
                gap = temp;

                answer1 = board[left];
                answer2 = board[right];
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

        System.out.println(answer1 + " " + answer2);




    }

}
