import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int C;
    static int[] kind;
    static int[][][] DP;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        kind = new int[N];
        DP = new int[(1<<N)-1][M][C+1];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        for(int i= 0; i<N; i++){
            kind[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(getS(0,0,C));

    }

    public static  int getS(int gemsBit, int bagIdx, int capacity){

            if( gemsBit == (1<<N) -1 || bagIdx == M)  return 0;

            if(DP[gemsBit][bagIdx][capacity] == 0){

                for(int i=0; i<N; i++){
                    if((gemsBit &(1<<i))>0) continue;

                    if(capacity>=kind[i]){
                        DP[gemsBit][bagIdx][capacity] = Integer.max(DP[gemsBit][bagIdx][capacity],
                                getS(gemsBit|1<<i,bagIdx,capacity-kind[i])+1);
                    }else{
                        DP[gemsBit][bagIdx][capacity] = Integer.max(DP[gemsBit][bagIdx][capacity],
                                getS(gemsBit,bagIdx+1,C));
                    }
                }
            }

            return DP[gemsBit][bagIdx][capacity];
    }
}