package HoYoon_Lee.bj10942_팰린드롬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        boolean[][] isPalindrome = new boolean[N][N];

        for(int i = 0; i < N; i++){
            isPalindrome[i][i] = true;
            if(i + 1 < N && numbers[i] == numbers[i + 1])
                isPalindrome[i][i + 1] = true;
        }

        for(int i = 2; i < N; i++){
            for(int j = 0; j < N - i; j++){
                if(numbers[j] == numbers[j + i] && isPalindrome[j + 1][j + i - 1])
                    isPalindrome[j][j + i] = true;
            }
        }

        while (M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write((isPalindrome[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]? 1 : 0) + "\n");
        }

        br.close();
        bw.close();
    }
}
