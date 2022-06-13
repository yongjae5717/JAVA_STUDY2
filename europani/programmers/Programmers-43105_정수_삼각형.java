import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                int tmp;
                if (j == 0) {
                    tmp = triangle[i-1][j];
                } else if (j == i) {
                    tmp = triangle[i-1][j-1];
                } else {
                    tmp = Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
                triangle[i][j] +=tmp;
            }
        }
        int max = Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        
        return max;
    }
}