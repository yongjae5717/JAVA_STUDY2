package HoYoon_Lee.programmers_소수찾기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private int[] numberArray;
    private boolean[] checked;
    private Set<Integer> primes = new HashSet<>();

    public int solution(String numbers) {
        numberArray = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        checked = new boolean[numberArray.length];
        Arrays.fill(checked, false);

        for(int i = 1; i <= numberArray.length; i++){
            findPrime(i, "");
        }

        return primes.size();
    }

    private void findPrime(int count, String permutation){
        if(count == 0 && isPrime(Integer.parseInt(permutation))) {
            primes.add(Integer.parseInt(permutation));
            return;
        }

        for(int i = 0; i < numberArray.length; i++){
            if(!checked[i]){
                checked[i] = true;
                findPrime(count - 1, permutation + numberArray[i]);
                checked[i] = false;
            }
        }
    }

    private boolean isPrime(int number){
        if(number < 2) return false;
        for(int i = 2; i <= (int)Math.sqrt(number); i++)
            if(number % i == 0) return false;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("011");
    }
}
