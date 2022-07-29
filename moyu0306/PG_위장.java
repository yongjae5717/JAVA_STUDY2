import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> list = new HashMap<>();
        for(String[] cloth:clothes){
            int number = list.getOrDefault(cloth[1],0);
            list.put(cloth[1],number+1);
        }
        for(String key:list.keySet()){
            int ea= list.get(key)+1;
            answer= answer*ea;
        }
        
        return answer-1;
    }
}