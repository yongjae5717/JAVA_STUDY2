import java.util.*;
import java.io.*;

class Main {
    static int N, S;
    static int result = 100001;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        String[] tmp = br.readLine().split(" ");
        for (int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
    }

    static void pro() {
        int left = 0, right = 0;
        int subSum = arr[0];

        while (left <= right) {
            if (subSum >= S) {
                result = Math.min(right-left+1, result);
                subSum-=arr[left];
                left+=1;
            } else {
                right+=1;
                if (right >= N) break;
                subSum+=arr[right];
            }
        }
    }
   
    public static void main(String[] args) throws IOException {
        input();
        pro();
        if (result == 100001) result=0;
        System.out.println(result);
    }
}