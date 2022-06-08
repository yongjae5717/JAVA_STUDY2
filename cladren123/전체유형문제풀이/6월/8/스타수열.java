package studyGroup.June.june8;

import java.util.*;


public class 스타수열 {


    public static void main(String[] args) {
        int[] a = {0};

        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int answer = -1;

        int an = a.length;
        int[] store = new int[an];

        // 숫자들의 갯수를 센다.
        for(int i = 0; i < an; i++)
        {
            store[a[i]] += 1;
        }

        // System.out.println(Arrays.toString(store));

        for(int i = 0; i < an; i++)
        {
            // 공통 원소가 아니면 넘어간다.
            if(store[i] == 0) continue;

            // 기존의 정답보다 작으면 넘어간다.
            if(store[i] <= answer) continue;

            int temp = 0;


            for(int j = 0; j < an-1; j++)
            {
                // 2개 중 한개는 공통된 원소를 가지고 있어야 한다.
                if(a[j] != i && a[j+1] != i) continue;

                // 인접한 두개의 값이 동일하지 않아야 한다.
                if(a[j] == a[j+1]) continue;

                temp += 1;
                j += 1;
            }

            answer = Math.max(answer, temp);


        }


        return answer * 2;
    }


}
