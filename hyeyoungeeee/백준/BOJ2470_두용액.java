package BOJ2470_두용액;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470_두용액 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int low = 0, high = N-1;
        int max = 2000000000;
        int[] result = new int[2];
        while (low < high) {
            int sum = arr[low] + arr[high];

            if (Math.abs(sum) < max) {
                result[0] = arr[low];
                result[1] = arr[high];
                max = Math.abs(sum);
            }

            if (sum > 0) high--;
            else low++;
        }
        System.out.println(result[0] + " " + result[1]);

    }
}