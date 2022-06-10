import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] seq;
    static int[] incCount;
    static int[] decCount;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        incCount = new int[N];
        decCount = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++) seq[i]= Integer.parseInt(stk.nextToken());

        for(int i=0; i<N; i++){
            for(int j=0; j<i;j++){
                if(seq[j]<seq[i]) incCount[i] = Integer.max(incCount[i],incCount[j]+1);
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>i;j--){
                if(seq[j]<seq[i]) decCount[i] = Integer.max(decCount[i],decCount[j]+1);
            }
        }

        for(int i=0; i<N; i++){
            max = Integer.max(max,incCount[i]+decCount[i]);
        }

        System.out.println(max+1);
    }
}