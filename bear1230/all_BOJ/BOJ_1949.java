import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] person;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        person = new int[n+1];
        dp = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            person[i] = Integer.parseInt(input[i-1]);
        }
        for (int i = 0; i < n - 1; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1, -1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int cur, int parent) {
        for (int child : tree.get(cur)) {
            if (child == parent) continue;
            dfs(child, cur);
            dp[cur][1] += dp[child][0];
            dp[cur][0] += Math.max(dp[child][0], dp[child][1]);
        }
        dp[cur][1] += person[cur];
    }
}