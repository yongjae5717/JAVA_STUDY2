import java.io.*;
import java.util.*;

class Solution {

    static boolean[][] isExisted = new boolean[51][51]; // 존재하는 지형인지? 
    static boolean[][] visited = new boolean[51][51]; // 방문한 지형인지?
    static int[][] memo = new int[51][51];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int answer = 0;
        
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = rectangle[i][0]; j <= rectangle[i][2]; j++) {
                isExisted[j][rectangle[i][1]] = true;
                isExisted[j][rectangle[i][3]] = true;
            }
            for (int j = rectangle[i][1]; j <= rectangle[i][3]; j++) {
                isExisted[rectangle[i][0]][j] = true;
                isExisted[rectangle[i][2]][j] = true;
            }            
        }
        
        answer = dfs(itemX, itemY, characterX, characterY);
        
        return answer;
    }
    
    private int dfs(int itemX, int itemY, int x, int y) {
            
        if (itemX == x && itemY == y) {
            return memo[x][y];
        }
        
        if (memo[x][y] > 0) {
            return memo[x][y];
        }
        
        if (!visited[x][y]) {
            visited[x][y] = true;
            if (x < 50 && isExisted[x + 1][y]) {
                memo[x][y] = dfs(itemX, itemY, x + 1, y) + 1;
                System.out.println("isExisted[x + 1][y] = " + memo[x][y]);
            }
            if (x > 1 && isExisted[x - 1][y]) {
                memo[x][y] = dfs(itemX, itemY, x - 1, y) + 1;                
                System.out.println("isExisted[x - 1][y] = " + memo[x][y]);

            }            
            if (y < 50 && isExisted[x][y + 1]) {
                memo[x][y] = dfs(itemX, itemY, x, y + 1) + 1;                
                System.out.println("isExisted[x][y+1] = " + memo[x][y]);

            }            
            if (y > 1 && isExisted[x][y - 1]) {
                memo[x][y] = dfs(itemX, itemY, x, y - 1) + 1;                
                System.out.println("isExisted[x][y-1] = " + memo[x][y]);

            }
            visited[x][y] = false;
        }
        return memo[x][y];
    }
}