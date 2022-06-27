import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int N;
    static int[][][] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        cost = new int[N][3][3];
        int answer  = 1000000;
        for(int i=0; i<3; i++) Arrays.fill(cost[0][i],1000000);
        for(int i=0; i<N; i++){
            String[] colorCosts = br.readLine().split(" ");
            int r = Integer.parseInt(colorCosts[0]);
            int g = Integer.parseInt(colorCosts[1]);
            int b = Integer.parseInt(colorCosts[2]);
            int before = (i-1 +N)%N;
            for(int j =0; j<3; j++){
                if(i == 0){
                    if( j == 0) cost[0][j][j] = r;
                    else if(j== 1) cost[0][j][j] = g;
                    else cost[0][j][j] = b;
                }else{
                    cost[i][0][j] = Integer.min(cost[before][1][j],cost[before][2][j]) + r;
                    cost[i][1][j] = Integer.min(cost[before][2][j],cost[before][0][j]) + g;
                    cost[i][2][j] = Integer.min(cost[before][0][j],cost[before][1][j]) + b;
                }
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
               if(i!=j){
                   answer = Integer.min(answer,cost[N-1][i][j]);
               }
            }
        }

        System.out.println(answer);
    }
}
