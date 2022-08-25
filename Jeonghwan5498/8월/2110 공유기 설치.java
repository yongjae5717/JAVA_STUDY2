import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int left = 0;
        int right = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }
        Arrays.sort(arr);

        while(left <= right){

            int mid = (left + right) / 2;
            //System.out.println("left = "+ left + " mid = " + mid + " right = " + right);

            int cnt = 1;
            int prev = arr[0];
            for(int i = 0; i < N; i++){
                if(arr[i] - prev >= mid){
                    prev = arr[i];
                    cnt++;
                }
            }
            //System.out.println("cnt = " + cnt);

            if(cnt >= C){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}



