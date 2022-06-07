package studyGroup.June.june7;

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

/*

백트래킹하면 시간초과

이제 n * n 격자에 k명의 사람을 배치할 때 유지 가능한 최대 간격을 구하는 문제를 풀면 된다.
각 거리별로 배치할 수 있는 최대의 사람을 찾는 것.

최대 거리부터 1까지 거리에 따라 사람이 몇 명 들어올 수 있는지 확인
i,j 시작점 설정
y,x 를 탐색해서 거리에 부합하면 채워넣는다.
최대 인원이 문제의 인원과 같다면 그 때의 거리값을 return 한다.

*/


public class 몸짱트레이너라이언의고민 {

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] timetable = {{1140,1200},{1150,1200},{1100,1200},{1210,1300},{1220,1280}};

//        int n = 3;
//        int m = 2;
//        int[][] timetable = {{1170,1210}, {1200,1260}};


        solution(n, m, timetable);
    }

    static int[][] board;
    static int[][] visited;
    static int num;
    static int answer;

    public static int solution(int n, int m, int[][] timetable) {

        answer = 0;

        board = new int[n][n];
        visited = new int[n][n];
        num = people(timetable);

        if(num <= 1)
        {
            return answer;
        }

        answer = calc(n);
        return answer;
    }

    // 거리를 계산하는 함수
    public static int calc(int n)
    {


        // 최대 거리는 2 * n - 2 이다.
        for(int dis = 2 * n - 2; dis > 0; dis--)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    ArrayList<dot> arr = new ArrayList<>();
                    arr.add(new dot(i,j));

                    for(int y = i; y < n; y++)
                    {
                        for(int x = 0; x < n; x++)
                        {
                            if(y == i && x <= j) continue;

                            boolean canPush = true;
                            for (dot d : arr)
                            {
                                int distance = Math.abs(d.y - y) + Math.abs(d.x - x);
                                if(distance < dis)
                                {
                                    canPush = false;
                                    break;
                                }
                            }

                            if(canPush)
                            {
                                arr.add(new dot(y,x));
                                if(num == arr.size())
                                {
                                    return dis;
                                }

                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public static class dot
    {
        int y;
        int x;

        dot(int y, int x)
        {
            this.y = y;
            this.x = x;
        }
    }




    // 가장 많이 곂칠 때 사람 수를 구하는 함수
    public static int people(int[][] timetable)
    {
        // 시작시간으로 정렬
        Arrays.sort(timetable, (o1, o2) -> o1[0] - o2[0]);

        int result = 0;

        // 끝나는 시간을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < timetable.length; i++)
        {

            while(!pq.isEmpty() && pq.peek() < timetable[i][0])
            {
                int one = pq.poll();
            }
            pq.add(timetable[i][1]);
            result = Math.max(result, pq.size());
        }

        return result;
    }




}
