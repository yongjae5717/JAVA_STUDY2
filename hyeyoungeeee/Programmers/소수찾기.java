import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    static boolean[] check;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        bfs(numbers, "", 0);

        return set.size();
    }

    static void bfs(String numbers, String now, int depth) {
        if(numbers.length() == depth) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                String concat = now + numbers.charAt(i);
                if(isPrime(Integer.parseInt(concat))){
                    set.add(Integer.parseInt(concat));
                }
                bfs(numbers, concat, depth + 1);
                check[i] = false;
            }
        }
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
