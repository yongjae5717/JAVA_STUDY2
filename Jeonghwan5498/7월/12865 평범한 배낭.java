import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static class item{
        int w;
        int v;

        public item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static int N;
    static int K;
    static item[] items;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        items = new item[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            items[i] = new item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dp = new int[N][K+1];
        System.out.println(doSearch(N-1, K));


    }

    public static int doSearch(int idx, int remain){

        if(idx < 0)
            return 0;

        if(dp[idx][remain] != 0)
            return dp[idx][remain];

        // i번째 물건을 담을 수 있는 경우
        if(remain >= items[idx].w){
            // i번째 물건을 담을 수 있는데 안 담는 경우 vs i번째 물건을 담은 경우
            dp[idx][remain] = Math.max(doSearch(idx - 1, remain), doSearch(idx-1, remain - items[idx].w) + items[idx].v);
        }
        // i번째 물건을 담을 수 없는 경우
        else{
            dp[idx][remain] = doSearch(idx-1, remain);
        }

        return dp[idx][remain];
    }
}
