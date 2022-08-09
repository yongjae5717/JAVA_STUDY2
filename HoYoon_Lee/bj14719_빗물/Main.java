package HoYoon_Lee.bj14719_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        for(int i = 1; i < W - 1; i++){
            int left = 0, right = 0;
            for(int j = 0; j < i; j++)
                left = Math.max(heights[j], left);
            for(int j = i + 1; j < W; j++)
                right = Math.max(heights[j], right);
            if(heights[i] < left && heights[i] < right)
                answer += Math.min(left, right) - heights[i];
        }

        System.out.println(answer);
    }
}
