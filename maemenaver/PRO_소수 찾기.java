import java.util.*;

// 소수에 대해서 생각해보자!
class Num {
    int selected;
    Queue<Integer> remains;

    Num(int _selected, int[] nums) {
        this.selected = _selected;
        this.remains = new ArrayDeque<Integer>(Arrays.asList(nums));
    }
}

class Solution {
    static int count = 0;

    public int solution(String numbers) {
        int[] nums = new int[numbers.length()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numbers.codePointAt(i) - 48;
        }

        int answer = nums[0];
        return answer;
    }
}