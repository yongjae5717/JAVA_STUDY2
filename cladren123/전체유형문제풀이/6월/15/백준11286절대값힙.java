package studyGroup.June.june15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 백준11286절대값힙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 우선순위큐 이중정렬 절대값 내림차순, 절대값이 같으면 일반값 내림차순
        PriorityQueue<dot> pq = new PriorityQueue<>(new Comparator<dot>() {
            @Override
            public int compare(dot o1, dot o2) {

                if(o1.abs == o2.abs)
                {
                    return o1.val - o2.val;
                }

                return o1.abs - o2.abs;
            }
        });

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int input = Integer.parseInt(br.readLine());

            if(input == 0)
            {
                if(pq.size() == 0)
                {
                    answer.add(0);
                }
                else
                {
                    int val = pq.poll().val;
                    answer.add(val);
                }
            }
            else
            {
                pq.add(new dot(Math.abs(input), input));
            }
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }


    }

    public static class dot
    {
        int abs;
        int val;

        dot(int abs, int val)
        {
            this.abs = abs;
            this.val = val;
        }



    }

}
