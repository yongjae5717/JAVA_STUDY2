import java.util.*;

class Solution {
    
    public String solution(String number, int k) {
        
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            list.add(number.charAt(i) - '0');
        }
        
        int idx = 0;
        for (int i = k; i < list.size(); i++) {
            int max = 0;
            for (int j = idx; j <= i; j++) {
                if (list.get(j) > max) {
                    max = list.get(j);
                    idx = j + 1;
                    if (max == 9) {
                        break;
                    }
                }
            }
            answer += max;
        }
        
        return answer;
    }
}