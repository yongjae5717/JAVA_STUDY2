package HoYoon_Lee.programmers_두큐합같게만들기;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = Arrays.stream(queue1).asLongStream().sum();
        long sum2 = Arrays.stream(queue2).asLongStream().sum();
        long total = sum1 + sum2;
        if(total % 2 == 1) return answer;

        long half = total / 2;
        int[] array = IntStream.concat(Arrays.stream(queue1), Arrays.stream(queue2)).toArray();
        if(Arrays.stream(array).anyMatch(i -> i > half)) return answer;

        int start = 0;
        int end = queue1.length;
        long sum = sum1;

        answer = 0;
        while (sum != half && answer != -1){
            if(sum > half) sum -= array[start++];
            else if(end < array.length) sum += array[end++];
            else answer = -1;
            if(answer != -1) answer++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] queue1 = {1, 1}, queue2 = {1, 5};
//        int[] queue1 = {1, 2, 1, 2}, queue2 = {1, 10, 1, 2};
//        int[] queue1 = {3, 2, 7, 2}, queue2 = {4, 6, 5, 1};
        new Solution().solution(queue1, queue2);
    }
}
