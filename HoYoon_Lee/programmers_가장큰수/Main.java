package HoYoon_Lee.programmers_가장큰수;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        String answer = list.stream().sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).collect(Collectors.joining());
        return answer.replaceFirst("^0+", "0");
    }
}

public class Main {
    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {0,0,0,70};
//        int[] numbers = {101, 10};
//        int[] numbers = {232, 23};
//        int[] numbers = {101, 10, 232, 23};
//        int[] numbers = {9, 998};
//        int[] numbers = {1, 104};
        int[] numbers = {0, 0, 1, 0, 0};

        new Solution().solution(numbers);
    }
}
