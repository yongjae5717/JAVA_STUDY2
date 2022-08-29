import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        // 목표값 설정
        int max_alp = 0;
        int max_cop = 0;
        for(int[] p : problems){
            max_alp = Math.max(max_alp, p[0]);
            max_cop = Math.max(max_cop, p[1]);
        }
        
        // 아웃라이어 처리
        if(max_alp <= alp && max_cop <= cop)
            return 0;
        if(alp >= max_alp)
            alp = max_alp;
        if(cop >= max_cop)
            cop = max_cop;
        
        // 초기값 설정
        int[][] dp = new int[max_alp+2][max_cop+2];
        for(int i = alp; i <= max_alp; i++){
            for(int j = cop; j <= max_cop; j++){
                dp[i][j] = 302;
            }
        }
        dp[alp][cop] = 0;
        
        // dp
        for(int i = alp; i <= max_alp; i++){
            for(int j = cop; j <= max_cop; j++){
                
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int[] p: problems){
                                 
                    if(i < p[0] || j < p[1])
                        continue;
                
                    if(i+p[2] > max_alp && j+p[3] > max_cop){
                        dp[max_alp][max_cop] = Math.min(dp[max_alp][max_cop], dp[i][j] + p[4]);
                    }
                    else if(i+p[2] > max_alp){
                        dp[max_alp][j+p[3]] = Math.min(dp[max_alp][j+p[3]], dp[i][j] + p[4]);
                    }
                    else if(j+p[3] > max_cop){
                        dp[i+p[2]][max_cop]=Math.min(dp[i+p[2]][max_cop], dp[i][j] + p[4]);
                    }
                    else if(i+p[2] <= max_alp && j+p[3] <= max_cop){
                       dp[i+p[2]][j+p[3]] = Math.min(dp[i+p[2]][j+p[3]], dp[i][j] + p[4]); 
                    }
                }
            }
        }
        return dp[max_alp][max_cop];    
    }
}