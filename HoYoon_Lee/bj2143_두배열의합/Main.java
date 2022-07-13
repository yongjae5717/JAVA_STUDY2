package HoYoon_Lee.bj2143_두배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long res = 0;
        int[] subA = new int[n + 1];
        int[] subB = new int[m + 1];
        Map<Integer, Integer> countSum = new HashMap<>();

        for(int i = 0; i < A.length; i++){
            subA[i + 1] = subA[i] + A[i];
            for(int j = 0; j <= i; j++) {
                int key = subA[i + 1] - subA[j];
                countSum.put(key, countSum.getOrDefault(key, 0) + 1);
            }
        }

        for(int i = 0; i < B.length; i++){
            subB[i + 1] = subB[i] + B[i];
            for(int j = 0; j <= i; j++){
                int key = T - (subB[i + 1] - subB[j]);
                res += countSum.getOrDefault(key, 0);
            }
        }

        System.out.println(res);
        br.close();
    }
}
