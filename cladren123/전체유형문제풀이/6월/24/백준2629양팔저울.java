package studyGroup.June.june24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://loosie.tistory.com/175

public class 백준2629양팔저울 {

    static int n;
    static int[] weights;
    static int m;


    static boolean[][] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        weights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        result = new boolean[n+1][40001];

        dp(0,0);


        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++)
        {
            int ball = Integer.parseInt(st.nextToken());
            if(result[n][ball])
            {
                sb.append("Y ");
            }
            else
            {
                sb.append("N ");
            }
        }

        System.out.println(sb.toString());

    }

    static void dp(int count, int num)
    {
        if(result[count][num]){
            return;
        }


        result[count][num] = true;

        if(count == n)
        {
            return;
        }

        dp(count + 1, num + weights[count]);
        dp(count + 1, num);
        dp(count + 1, Math.abs(num - weights[count]));
    }


}
