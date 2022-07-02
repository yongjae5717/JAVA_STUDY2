package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022-07-02

public class BOJ2473_세용액 {
    static int N;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/BOJ2473_세용액/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result = new int[3];
        long max = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int low = i+1, high = N-1;

            while (low < high) {
                long sum = (long) arr[low] + arr[high] + arr[i];
                if(Math.abs(sum) < max){
                    result[0] = arr[i];
                    result[1] = arr[low];
                    result[2] = arr[high];
                    max = Math.abs(sum);
                }

                if(sum > 0) high--;
                else low++;
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);

    }
}