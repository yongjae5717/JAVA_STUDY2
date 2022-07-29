package HoYoon_Lee.programmers_조이스틱;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String name) {
        final int[] leftRight = {1, name.length() - 1};
        int answer = 0;
        int isMove = 0;

        for(int i = 0; i < name.length(); i++){
            int countUp = name.charAt(i) - 'A';
            if(countUp != 0) {
                isMove |= 1 << i;
                answer += countUp < 13 ? countUp : 26 - countUp;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(isMove & ~1);

        int cnt = 0;
        LOOP:
        while (!queue.isEmpty()){
            int size = queue.size() / 2;
            while (size-- > 0) {
                int index = queue.poll();
                int status = queue.poll();
                if(status == 0) break LOOP;

                for(int move : leftRight){
                    int nextIndex = (index + move) % name.length();
                    queue.offer(nextIndex);
                    queue.offer(status & ~(1 << (nextIndex)));
                }
            }
            cnt++;
        }

        return answer + cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("JEROEN");
    }
}
