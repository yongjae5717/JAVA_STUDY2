import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        // A 배열 입력받기
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++ ){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 배열 입력받기
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++ ){
            B[i] = Integer.parseInt(st.nextToken());
        }

        long[] subA = new long[N*(N+1)/2];
        long[] subB = new long[M*(M+1)/2];
        int idx; long sum;

        // A 부배열 만들기
        idx = 0;
        for(int i = 0; i < N-1; i++){
            sum = A[i];
            subA[idx++] = sum;
            for(int j = i+1; j < N; j++){
                sum += A[j];
                subA[idx++] = sum;
            }
        }
        subA[idx] = A[N-1];

        // B 부배열 만들기
        idx = 0;
        for(int i = 0; i < M-1; i++){
            sum = B[i];
            subB[idx++] = sum;
            for(int j = i+1; j < M; j++){
                sum += B[j];
                subB[idx++] = sum;
            }
        }
        subB[idx] = B[M-1];


        Arrays.sort(subA);
        Arrays.sort(subB);


        int p1 = 0, p2 = M*(M+1)/2 - 1;
        long count = 0, countA, countB;

        while( p1 < N*(N+1)/2 && 0 <= p2){

            if( T == subA[p1] + subB[p2] ){

                countA = 1;
                while( p1+1 < N*(N+1)/2 && subA[p1] == subA[p1+1] ){
                    p1++;
                    countA++;
                }
                countB = 1;
                while( p2-1 >= 0 && subB[p2] == subB[p2-1] ){
                    p2--;
                    countB++;
                }
                count += countA*countB;

                p1++;
                p2--;
            }
            else if ( T < subA[p1] + subB[p2] ){
                p2--;
            }
            else{
                p1++;
            }
        }
        System.out.println(count);
    }
}