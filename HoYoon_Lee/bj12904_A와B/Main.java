package HoYoon_Lee.bj12904_A와B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String reverseS = new StringBuilder(S).reverse().toString();
        String T = br.readLine();
        int answer = 0;
        boolean isReversed = false;

        while (T.length() > S.length()){
            int start = 0, end = T.length() - 1, index;
            if(!isReversed) index = end--;
            else index = start++;

            if(T.charAt(index) == 'B')
                isReversed = !isReversed;
            T = T.substring(start, end + 1);
            if((!isReversed && T.equals(S)) || (isReversed && T.equals(reverseS))) answer = 1;
        }

        System.out.println(answer);
        br.close();
    }
}
