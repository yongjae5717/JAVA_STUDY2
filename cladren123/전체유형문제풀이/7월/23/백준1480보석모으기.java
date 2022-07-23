package studyGroup.july.july23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

bitmast + dp



 */


public class 백준1480보석모으기 {

    static int MAX = 14; // 보석의 개수 n은  13보다 작거나 같다.
    static int n, m, c;
    static int[] board;
    static int[][][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 보석의 개수
        m = Integer.parseInt(st.nextToken()); // 가방의 개수
        c = Integer.parseInt(st.nextToken()); // 가방의 최대 한도

        board = new int[n];

        // 1 << max : max개의 비트를 생성한다. <<은 정수1을 왼쪽으로 14만큼 이동이라는 뜻 이다.
        // 보석의 크기는 13보다 작다 -> 1 << max
        // 보석의 크기는 10보다 작다. -> 11
        // 가방의 최대한도는 20보다 작다 -> 21
        dp = new int[1 << MAX][11][21];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dfs(0,0,c);
        System.out.println(answer);


    }

    // path : 탐색한 보석의 index
    // idx : 가방의 순서
    // k : 쓸 수 있는 가방의 용량 (남아 있는 양)
    public static int dfs(int path, int idx, int cap) {


        // 모든 보석이나, 모든 가방을 사용했다면 return
        if(( (path == (1<<n)-1) || idx == m ))
        {
            return 0;
        }


        // 이미 방문한 곳이면
        if(dp[path][idx][cap] != 0) {
            return dp[path][idx][cap];
        }

        for(int i = 0; i < n; i++)
        {
            // 이미 사용된 보석이거나 남은 용량이 해당 보석의 무게보다 작다면 무시
            if( (path & (1 << i)) > 0)
            {
                continue;
            }


            if(cap >= board[i])
            {
                dp[path][idx][cap] = Math.max(dp[path][idx][cap], dfs(path | (1 << i), idx, cap - board[i]) + 1);
            }
            else
            {
                // 용량이 조금 남았더라도, 다음 가방(idx + 1) 탐색
                dp[path][idx][cap] = Math.max(dp[path][idx][cap], dfs(path, idx+1, c));
            }


        }


        return dp[path][idx][cap];

    }

}
