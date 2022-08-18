import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] arr;
    static String[] result;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N;
        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = 1;
            int prevIdx = 0;
            for (int nextIdx = 0; nextIdx < K; nextIdx++) {
                if (arr[nextIdx] - arr[prevIdx] >= mid) {
                    prevIdx = nextIdx;
                    cnt++;
                }
            }
            if (cnt < M)
                right = mid - 1;
            else
                left = mid + 1;
        }

        result = new String[K];
        Arrays.fill(result, "0");
        result[0] = "1";

        int prevIdx = 0;
        int cnt = 1;
        for (int nextIdx = 0; nextIdx < K; nextIdx++) {
            if(arr[nextIdx] - arr[prevIdx] >= right) {
                prevIdx = nextIdx;
                result[nextIdx] = "1";
                cnt++;
            }
            if(cnt == M)
                break;
        }
        System.out.println(String.join("", result));
    }
}




