package studyGroup.july.july11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*

어떻게 동전이 무한히 움직이는 것을 판단할 수 있는가
https://subbak2.tistory.com/7

 */

public class 백준1103게임 {

    static int n,m; // 세로 가로
    static int[][] map;

    static int[][] dp;

    static long answer;
    static boolean[][] visited;

    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};

    static boolean iflag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < m; j++)
            {
                if(str.charAt(j) == 'H')
                    map[i][j] = 10;
                else
                    map[i][j] = str.charAt(j) - 48;
            }
        }

        visited[0][0] = true;
        iflag = false;
        dfs(0,0,1);

        if(iflag) System.out.println(-1);
        else System.out.println(answer);

    }

    static void dfs(int y, int x, int count)
    {
        if(count > answer)
        {
            answer = count;
        }

        dp[y][x] = count;

        for(int i = 0; i < 4; i++)
        {
            int num = map[y][x];
            int ny = y + dy[i] * num;
            int nx = x + dx[i] * num;

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 10)
                continue;

            if(visited[ny][nx])
            {
                iflag = true;
                return;
            }

            if(dp[ny][nx] > count) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, count + 1);
            visited[ny][nx] = false;
        }

    }



}
