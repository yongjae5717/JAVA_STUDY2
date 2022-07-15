import java.util.*;

class Solution {
    
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] map;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        map = new boolean[102][102];
        for(int i = 0; i < rectangle.length; i++){
            for(int j = 0; j < rectangle[0].length; j++){
                rectangle[i][j] *= 2;
            }
            
            for(int j = rectangle[i][1]; j <= rectangle[i][3]; j++){
                for(int k = rectangle[i][0]; k <= rectangle[i][2]; k++){
                    map[j][k] = true;    
                }
            }
        }
        for(int i = 0; i < rectangle.length; i++){
            for(int j = rectangle[i][1] + 1; j < rectangle[i][3]; j++){
                for(int k = rectangle[i][0] + 1; k < rectangle[i][2]; k++){
                    map[j][k] = false;    
                }
            }
        } 
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;      
        int answer = BFS(rectangle, characterX, characterY, itemX, itemY);
        return answer / 2;
    }
    
    public int BFS(int[][] rectangle, int cx, int cy, int tx, int ty){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {cx, cy, 0});
        map[cy][cx] = false;
        
        while(!queue.isEmpty()){
            
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];
            int distance = q[2];
            
            if(x == tx && y == ty){
                return distance;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(map[ny][nx]){
                    map[ny][nx] = false;
                    queue.add(new int[] {nx, ny, distance + 1});
                }
            }
        }
        return 0;
    }
}