import java.util.*;

class Solution {
    
    static HashMap<String, Integer> dic;
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static int idx = 1;
    
    public int solution(String word) {
        
        dic = new HashMap<>();
        dfs(0, "");
        
        return dic.get(word);
        
    }
    
    public void dfs(int depth, String str){
        
        if(depth >= 5){
            return;
        }
        depth++;
        
        for(int i = 0; i < 5; i++){
            String nstr = str + alpha[i];
            if(!dic.containsKey(nstr)){
                dic.put(nstr, idx++);
            }
            dfs(depth, nstr);
        }
    }
}