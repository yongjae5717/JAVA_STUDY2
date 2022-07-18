package HoYoon_Lee.bj1644_소수의연속합;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        List<Integer> primes = new ArrayList<>();

        int start = 0, sum = 0;
        int answer = 0;
        LOOP:
        for(int i = 2; i <= N; i++) {
            for (int j = 0; j < primes.size() && primes.get(j) <= Math.sqrt(i); j++)
                if (i % primes.get(j) == 0) continue LOOP;
            primes.add(i);
            sum += i;
            while (sum > N && start < primes.size()) sum -= primes.get(start++);
            if(sum == N) answer++;
        }
        System.out.println(answer);
    }
}
