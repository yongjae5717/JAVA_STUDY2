package studyGroup.June.june6;

import java.util.*;
import java.lang.*;
import java.io.*;

/*

https://moonsbeen.tistory.com/376

누적합, 투포인터

반례

입력)
10
1 10
1 10
2 10
3 10
1 9
1 8
1 7
2 3
3 1
3 1

정답)
5
5
26
27
5
5
5
2
0
0

 */

public class 백준10800컬러볼 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ball[] balls = new ball[n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int ballSize = Integer.parseInt(st.nextToken());
            balls[i] = (new ball(i, color, ballSize));
        }

        Arrays.sort(balls, (o1, o2) -> o1.ballSize - o2.ballSize);





        int[] result = new int[n]; // 결과 저장
        int[] colors = new int[n+1]; // 색깔별 합
        int ballindex = 0;
        int sum = 0; // 전체합

        for(int i = 0; i < n; i++)
        {
            ball current = balls[i];
            while(balls[ballindex].ballSize < current.ballSize)
            {
                sum += balls[ballindex].ballSize;
                colors[balls[ballindex].color] += balls[ballindex].ballSize;
                ballindex++;
            }
            result[current.index] = sum - colors[current.color];
        }

        for (int i : result) {
            System.out.println(i);
        }




    }

    public static class calcBall
    {
        int ballSize;
        int count;

        calcBall(int ballSize, int count)
        {
            this.ballSize = ballSize;
            this.count = count;
        }
    }

    public static class ball
    {
        int index;
        int color;
        int ballSize;

        ball(int index, int color, int ballSize )
        {
            this.index = index;
            this.color = color;
            this.ballSize = ballSize;
        }
    }

}
