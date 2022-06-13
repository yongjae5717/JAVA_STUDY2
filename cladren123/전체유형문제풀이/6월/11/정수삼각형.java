package studyGroup.June.june11;

import java.util.*;

public class 정수삼각형 {

    public static void main(String[] args) {

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle));

    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;

        for(int i = 1; i < n; i++)
        {
            int m = triangle[i].length;

            for(int j = 0; j < m; j++)
            {
                if(j == 0)
                    triangle[i][j] += triangle[i-1][j];
                else if(j == m-1)
                    triangle[i][j] += triangle[i-1][j-1];
                else
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);

            }
        }

        for(int i = 0; i < triangle[n-1].length; i++)
            answer = Math.max(answer, triangle[n-1][i]);


        return answer;
    }

}
