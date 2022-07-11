import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> primes = new HashSet<>();
        countPrime(numbers, "", primes);

        return primes.size();
    }

    public int countPrime(String num, String cur, Set<Integer> primes) {
        if (num.length() == 0)
            return isPrime(cur, primes);

        int count = isPrime(cur, primes);
        for (int i = 0; i < num.length(); i++) {
            String nextnum = num.substring(0, i) + num.substring(i + 1);
            String nextcur = cur + num.substring(i, i + 1);
            count += countPrime(nextnum, nextcur, primes);
        }

        return count;
    }

    public int isPrime(String number, Set<Integer> primes) {
        if (number.length() == 0) return 0;
        System.out.println(number);
        int num = Integer.valueOf(number);
        if (num < 2) return 0;
        int count = 0;


        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                System.out.println(i);
                return 0;
            }
        }

        System.out.println("prime");

        primes.add(num);
        return 1;
    }
}