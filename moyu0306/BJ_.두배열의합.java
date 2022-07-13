import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int T;
    static int N;
    static int M;
    static long[] arrA;
    static long[] arrB;
    static HashMap<Long,Long> Asum;
    static HashMap<Long,Long> Bsum;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        Asum = new HashMap<>();
        Bsum = new HashMap<>();
        T= Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arrA = new long[N+1];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<N+1; i++){
            if(i==1){
                arrA[1] =Integer.parseInt(stk.nextToken());
            }else arrA[i] = arrA[i-1]+ Integer.parseInt(stk.nextToken());
        }
        for(int i=1; i<N+1; i++){
            for(int j=i; j<N+1; j++){
                long sum =arrA[j] - arrA[i-1];
                Asum.put(sum,Asum.getOrDefault(sum,0L)+1);
            }
        }

        M = Integer.parseInt(br.readLine());
        arrB = new long[M+1];
        stk = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<M+1; i++){
            if(i==1){
                arrB[1] =Integer.parseInt(stk.nextToken());
            }else arrB[i] = arrB[i-1]+ Integer.parseInt(stk.nextToken());
        }
        for(int i=1; i<M+1; i++){
            for(int j=i; j<M+1; j++){
                long sum =arrB[j] - arrB[i-1];
                Bsum.put(sum,Bsum.getOrDefault(sum,0L)+1);
            }
        }

        for(long num :Asum.keySet()){
            long Acount = Asum.get(num);
            long Bcount = Bsum.getOrDefault(T-num,0L);
            answer+=Acount*Bcount;
        }

        System.out.print(answer);
    }
}