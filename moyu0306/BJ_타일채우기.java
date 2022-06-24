import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static long DP[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        DP= new long[N+1];
        DP[0] = 1;
        DP[1] = 1;
        if(N%2 == 1){
            System.out.println(0);
            return;
        }
        for(int i= 2; i< N+1; i++){
            DP[i] = DP[i-2]*3;
            for(int j= 4; j<=i; j+=2){
                DP[i]+= DP[i-j]*2;
            }
        }
        System.out.println(DP[N]);
    }
}