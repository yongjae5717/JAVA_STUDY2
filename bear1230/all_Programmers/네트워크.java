import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {  
        int answer = 0;   
        boolean[] visited = new boolean[n];   
        Queue<int[]> que = new LinkedList<>();
    
        for(int i=0; i<computers.length; i++) {
            if(visited[i]) continue;
            que.offer(computers[i]);
            visited[i] = true;
            
            while(!que.isEmpty()) {
                int[] computer = que.poll();
                for(int j=0; j<computer.length; j++) {          
                    if(!visited[j] && computer[j] == 1) {                  
                        que.offer(computers[j]);                  
                        visited[j] = true;            
                    }           
                }
            }
            answer++;
  
        }
        return answer;

    }
}
