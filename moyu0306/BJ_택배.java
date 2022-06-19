import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N,M;
    static int[][] adjMatrix;
    static int[][] nxtStep;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        adjMatrix = new int[N + 1][N + 1];
        nxtStep = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) Arrays.fill(adjMatrix[i], 100000000);
        for (int i = 0; i <N+1; i++){
            for(int j=0; j<N+1; j++) nxtStep[i][j] = j;
        }
        for (int i = 0; i < M; i++) {
            String[] num = br.readLine().split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);
            int dist = Integer.parseInt(num[2]);
            adjMatrix[a][b] = dist;
            adjMatrix[b][a] = dist;
        }

        for(int k=1; k<N+1; k++){
            for(int i=1; i<N+1; i++){
                for(int j=1; j<N+1; j++){
                    int val = adjMatrix[i][k]+adjMatrix[k][j];
                    if(adjMatrix[i][j]>val){
                        adjMatrix[i][j] = val;
                        nxtStep[i][j] = nxtStep[i][k];
                    }
                }
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                sb.append((i==j) ? "-" : nxtStep[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}