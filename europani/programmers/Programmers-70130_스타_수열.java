// 답안 확인
import java.util.*;

class Solution {
    public int solution(int[] a) {
        if (a.length < 2) {
            return 0;
        }
        
        int[] numbers = new int[a.length];
        for (int n : a) {
            numbers[n]++;
        }
        
        int answer = 0;
        for (int n=0; n < a.length; n++) {      // (0 ~ n-1) 숫자 선회
            if (numbers[n] <= answer) continue;
            int tmp = 0;
            for (int i=0; i < a.length-1; i++) {    // 스타수열 판별
                if (a[i] == a[i+1]) continue;
                if (a[i] != n && a[i+1] != n) continue;
                
                i++;    // 조건 충족시 +2
                tmp++;
            }
            answer = Math.max(tmp, answer);
        }   
        
        return answer*2;
    }
}