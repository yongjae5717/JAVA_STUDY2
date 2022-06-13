import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[] seq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        seq = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) seq[i] = Integer.parseInt(stk.nextToken());

        int min = N+1;
        int sum = 0;
        int count = 0;
        for(int i=0, j = 0; i<N ||j<N;){
            if(sum< M && i<N){
                sum += seq[i];
                count++;
                i++;
            }else{
                sum -= seq[j];
                count --;
                j++;
            }

            if(sum >= M){
                min = Integer.min(min,count);
            }
            if(sum<M && i==N) break;
        }
        System.out.println((min==N+1) ? 0 : min);
    }
}