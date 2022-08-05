import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = buyBottle(N, K);
        System.out.println(result);
    }

    private static int buyBottle(int n, int k) {
        if(n <= k) return 0;

        for (int loop = 0; loop < k - 1; loop++) {
            int base = 0;
            while (Math.pow(2, base) < n) {
                base++;
            }
            n -= Math.pow(2, base - 1);
            if(n == 0) return 0;
        }
        int base = 0;
        while (Math.pow(2, base) < n) {
            base++;
        }
        return (int) Math.pow(2, base) - n;
    }
}