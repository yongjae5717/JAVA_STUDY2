package studyGroup.June.june1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/*

메모리 초과 발생..

1. Queue의 타입 클래스를 변경. dp로 시간 체크
2. 선수과목들을 일일히 다 정하는게 아니라 갯수로 저장

https://steady-coding.tistory.com/182

 */

public class 백준2056작업 {

    static int n;
    static int[] indegree;
    static int[] timeBoard;
    static int[] dp;
    static ArrayList<ArrayList<Integer>> board;
    static Queue<Integer> que;
    static int time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        indegree = new int[n + 1];
        timeBoard = new int[n + 1];
        dp = new int[n + 1];
        board = new ArrayList<>();
        que = new LinkedList<>();

        for (int i = 0; i < n + 1; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            String[] strList = str.split(" ");

            timeBoard[i] = Integer.parseInt(strList[0]);
            indegree[i] = Integer.parseInt(strList[1]);

            for (int j = 2; j < strList.length; j++) {
                int one = Integer.parseInt(strList[j]);
                board.get(one).add(i);
            }
        }

        for (int i = 1; i <= n; i++) {

            dp[i] = timeBoard[i];

            if (indegree[i] == 0) {
                que.add(i);
            }
        }

        time = 0;

        while (!que.isEmpty()) {
            Integer now = que.poll();

            for (int next : board.get(now)) {
                indegree[next]--;

                // C라는 작업이 A, B를 필요로 한다. 이 때 A는 10, B는 20이 필요로 한다면
                // C라는 작업을 하기 위해서는 20이 필요하다.

                dp[next] = Math.max(dp[next], dp[now] + timeBoard[next]);

                if (indegree[next] == 0) {
                    que.add(next);
                }
            }
        }

        for(int i = 1; i <= n; i++)
        {
            time = Math.max(time, dp[i]);
        }

        System.out.println(time);


    }
}
