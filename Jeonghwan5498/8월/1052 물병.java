import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // N개의 물병으로 K개 이하로 남길 수 없다면
        if (N <= K) {
            System.out.println(0);
            return;
        }

        int buy = 0;


        while(true){
            int count = 0;
            int copyN = N;

            // 2진수 N의 1의 개수
            while(copyN != 0){
                if(copyN % 2 == 1){
                    count += 1;
                }
                copyN /= 2;
            }

            // 2진수 N의 1의 개수 <= K 이라면
            if(count <= K)
                break;
            
            // 2진수 N의 1의 개수 > K라면
            
            // 물통을 산다.
            N += 1;
            buy += 1;
        }
        System.out.println(buy);
    }
}
