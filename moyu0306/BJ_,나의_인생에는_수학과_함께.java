import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static int[][][] DP;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        DP = new int[N][N][2];
        for(int i=0; i<N; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j] = stk.nextToken().charAt(0);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                DP[i][j][0] = Integer.MIN_VALUE;
            }
        }
        DP[0][0][0] = map[0][0] - '0';
        DP[0][0][1] = map[0][0] - '0';

        int[] answer = getVal(N-1,N-1);
        System.out.println(answer[0]+" "+answer[1]);
    }

    public static int[] getVal(int i, int j){
        if(DP[i][j][0] == Integer.MIN_VALUE){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            if(i>=2){
                max = Integer.max(max,calculate(getVal(i-2,j)[0],map[i][j],map[i-1][j]));
                min = Integer.min(min,calculate(getVal(i-2,j)[1],map[i][j],map[i-1][j]));
            }
            if(j>=2){
                max = Integer.max(max,calculate(getVal(i,j-2)[0],map[i][j],map[i][j-1]));
                min = Integer.min(min,calculate(getVal(i,j-2)[1],map[i][j],map[i][j-1]));
            }

            if(i>=1 && j>=1){
                max = Integer.max(max,calculate(getVal(i-1,j-1)[0],map[i][j],map[i-1][j]));
                max = Integer.max(max,calculate(getVal(i-1,j-1)[0],map[i][j],map[i][j-1]));
                min = Integer.min(min,calculate(getVal(i-1,j-1)[1],map[i][j],map[i-1][j]));
                min = Integer.min(min,calculate(getVal(i-1,j-1)[1],map[i][j],map[i][j-1]));
            }
            DP[i][j] = new int[]{max,min};
        }
        return DP[i][j];
    }
    public static int calculate(int opnd1, char opnd2, char op){
        int num1 = opnd1;
        int num2 = opnd2-'0';
        int val = 0;
        if(op =='+') val = num1+num2;
        else if(op =='-') val = num1 - num2;
        else val = num1*num2;

        return val;
    }
}