class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            System.out.println("i = " + i);
            answer += dfs(i, computers);
        }
        
        return answer;
    }
    
    int dfs(int idx, int[][] computers) {
        visited[idx] = true;
        for (int i = 0 ; i < computers[0].length; i++) {
            if (visited[i] || computers[idx][i] == 0) continue;
            dfs(i, computers);
        }
        return 1;
    }
}