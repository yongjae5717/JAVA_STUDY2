package HoYoon_Lee.programmers_위장;

import java.util.Arrays;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes).collect(groupingBy(c -> c[1], counting()))
                .values()
                .stream()
                .reduce(1L, (x, y) -> (x) * (y + 1)).intValue() - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        new Solution().solution(clothes);
    }
}
