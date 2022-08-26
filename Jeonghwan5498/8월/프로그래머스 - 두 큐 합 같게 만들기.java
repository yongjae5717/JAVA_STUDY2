import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static long target, sum;
    static int maxDepth;

    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        sum = 0L;

        for(int i = 0; i < queue1.length; i++){
            sum += queue1[i];
            q1.add(queue1[i]);
        }
        for(int i = 0; i < queue2.length; i++){
            sum += queue2[i];
            q2.add(queue2[i]);
        }
        // 정답이 존재하지 않는다면
        if(sum % 2 == 1){
            return -1;
        }
        target = sum / 2;
        
        Long sum1 = q1.stream().mapToLong(Integer::intValue).sum();
        
        for(int i = 0; i < (queue1.length + queue2.length) * 2; i++){
            if(sum1 == target){
                return i;
            }
            else if(sum1 > target){
                int temp = q1.poll();
                sum1 -= temp;
                q2.add(temp);
            }
            else{
                int temp = q2.poll();
                sum1 += temp;
                q1.add(temp); 
            }
        }
        return -1;
    }
}