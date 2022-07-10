package studyGroup.july.july9;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

    public static void main(String[] args) {

        int[] numbers = {6, 10, 2};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers)
    {
        String answer = "";

        int n = numbers.length;

        String[] snum = new String[n];

        for(int i = 0; i < n; i++)
        {
            snum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(snum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2)
            {
                // o1 = 3 o2 = 30
                // 330과 303비교 내림차순으로 정렬
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for(int i = 0; i < n; i++)
        {
            answer += snum[i];
        }

        return answer;

    }





}
