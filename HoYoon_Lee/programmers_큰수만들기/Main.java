package HoYoon_Lee.programmers_큰수만들기;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int l = number.length() - k;
        String[] numbers = number.split("");

        int idx = -1;
        while (l-- > 0){
            String max = "";
            for(int i = idx + 1; i < numbers.length - l; i++){
                if(numbers[i].compareTo(max) > 0){
                    max = numbers[i];
                    idx = i;
                }
                if(max.equals("9")) break;
            }
            answer.append(max);
        }
        return answer.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("654321", 1);
    }
}
