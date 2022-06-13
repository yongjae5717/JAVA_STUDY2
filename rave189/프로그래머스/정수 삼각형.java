package Programmers;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
	}
}

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length+1][triangle.length+1];
        for(int i=1; i<=triangle.length; i++) {
            for(int j=1; j<=i; j++) {
                int v = triangle[i-1][j-1];
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + v;
            }
        }
        int answer = 0;
        for(int i=1; i<=triangle.length; i++)
            answer = Math.max(answer, dp[triangle.length][i]);
        return answer;
    }
}