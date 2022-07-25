package HoYoon_Lee.bj1480_보석모으기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] dp;
    private static int N, M, C;
    private static int[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        jewels = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp = new int[M + 1][(1 << (N + 1))][C + 1];

        System.out.println(getMaxJewels(0, 0, 0));
    }

    private static int getMaxJewels(int bagNum, int state, int weight) {
        if(bagNum == M) return Integer.bitCount(state);
        if(dp[bagNum][state][weight] != 0) return dp[bagNum][state][weight];

        for(int i = 0; i < N; i++){
            int bit = 1 << i;
            if((bit & state) > 0) continue;
            if(weight + jewels[i] <= C)
                dp[bagNum][state][weight] = Math.max(dp[bagNum][state][weight],
                        getMaxJewels(bagNum, state | bit, weight + jewels[i]));
        }
        dp[bagNum][state][weight] = Math.max(dp[bagNum][state][weight],
                getMaxJewels(bagNum + 1, state, 0));
        return dp[bagNum][state][weight];
    }
}

/* ???????맞왜틀??????? */

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.List;
//import java.util.StringTokenizer;
//import java.util.stream.Collectors;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());
//        List<Integer> jewels = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
//
//        while (M-- > 0){
//            int[] dp = new int[C + 1];
//            int[] taken = new int[C + 1];
//
//            for (int i = 1; i <= jewels.size(); i++){
//                int jewel = jewels.get(i - 1);
//                for(int w = 1; w <= C; w++){
//                    if(w < jewel) continue;
//                    int nextWeight, nextBit, bit = 1 << (i - 1);
//                    if((taken[w - jewel] & bit) > 0){
//                        nextWeight = dp[w - jewel];
//                        nextBit = taken[w - jewel];
//                    }
//                    else{
//                        nextWeight = dp[w - jewel] + jewel;
//                        nextBit = taken[w - jewel] | bit;
//                    }
//                    if(dp[w] < nextWeight && Integer.bitCount(taken[w]) <= Integer.bitCount(nextBit)){
//                        dp[w] = nextWeight;
//                        taken[w] = nextBit;
//                    }
//                }
//            }
//
//            for(int i = jewels.size() - 1; i >= 0; i--)
//                if((taken[C] & (1 << i)) > 0) jewels.remove(i);
//        }
//        System.out.println(N - jewels.size());
//        br.close();
//    }
//}
