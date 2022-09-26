import java.util.*;

class Solution {
    
    class Rate{
        int idx;
        double rate;
        
        public Rate(int idx, double rate){
            this.idx = idx;
            this.rate = rate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        
        int[] user_fal = new int[N + 2];
        int[] user_cnt = new int[N + 2];
        
        for(int i = 0; i < stages.length; i++ ){
            for(int j = 1; j <= stages[i]; j++ ){
                user_cnt[j]++;
            }
            user_fal[stages[i]]++;
        }
        
        ArrayList<Rate> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++ ){
            
            if(user_cnt[i] == 0){
                arr.add(new Rate(i, 0));
            }
            else{
                arr.add(new Rate(i, (double)user_fal[i] / user_cnt[i] ));
            }
        }
        
        Collections.sort(arr, ((o1, o2) -> Double.compare(o2.rate, o1.rate)) );
        
        int[] answer = new int[N];
        for(int i = 0; i < arr.size(); i++ ){
            answer[i] = arr.get(i).idx;
        }
        return answer;
    }
}