package studyGroup.july.july29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://loosie.tistory.com/501

public class 백준1135뉴스전하기 {

    static int n;


    static List<Integer>[] list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList[n];
        int rt = 0;
        dp = new int[n];


        for(int i = 0; i < n; i++)
        {
            list[i] = new ArrayList<>();
            int a = Integer.parseInt(st.nextToken());

            if(a == -1) {
                rt = i;
            }
            else {
                list[a].add(i);
            }

        }

        int min = solve(rt);
        System.out.println(min);


    }

    static int solve(int index) {

        for(int next : list[index]) {
            dp[next] = 1 + solve(next);
        }

        Collections.sort(list[index], new DepthComp());
        int res = 0;

        for(int i = 0; i < list[index].size(); i++) {
            int num = list[index].get(i);
            dp[num] += i;
            res = Math.max(res, dp[num]);
        }

        return res;

    }

    static class DepthComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return dp[o2] - dp[o1];
        }



    }

}
