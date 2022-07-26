import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int N;
    static int K;
    static int DP [][];
    static int[][] goodsList;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        goodsList = new int[N][2];
        DP = new int[N][K+1];

        for(int i=0; i<N; i++){
            String[] goods = br.readLine().split(" ");
            goodsList[i][0] = Integer.parseInt(goods[0]);
            goodsList[i][1] = Integer.parseInt(goods[1]);
        }
        Arrays.sort(goodsList,(a, b)->{return a[0]- b[0];});

        System.out.println(getTotalValue(0,K));

    }

    public static int getTotalValue(int idx, int weight){

        if(idx == N ) return 0;
        if(DP[idx][weight] == 0){
            int val = 0;
            for(int i= idx; i<N; i++){
                if(weight>= goodsList[i][0]){
                    int candVal =  getTotalValue(i+1,weight- goodsList[i][0]);
                    val = Integer.max(goodsList[i][1] + candVal, val);
                }else break;
            }
            DP[idx][weight] = val;
        }

        return DP[idx][weight];
    }
}
