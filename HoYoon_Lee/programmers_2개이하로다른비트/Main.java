package HoYoon_Lee.programmers_2개이하로다른비트;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();

        for(int i = 0; i < numbers.length; i++){
            answer[i]++;
            answer[i] += (answer[i]^numbers[i]) >>> 2;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
