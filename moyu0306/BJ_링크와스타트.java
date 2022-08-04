import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

    static int[][] chemistry;
    static int N;
    static int answer = 40000;
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        N = Integer.parseInt(br.readLine());
        chemistry = new int[N][N];

        for(int i=0; i<N; i++){
            String[] nums = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                chemistry[i][j] = Integer.parseInt(nums[j]);
            }
        }
        int dividedCnt = (int)Math.pow(2,N-1)-1;

        for(int i= 0; i<dividedCnt; i++){
            int num = i;
            num = (num<<1)+1;
            answer = Integer.min(answer,calcPoint(num));
        }
        System.out.println(answer);
    }

    public static int calcPoint(int state){
        int link = 0;
        int start = 0;
        for(int  i= 0; i<N-1; i++){
            boolean flag = ((state&1<<i)>0);
            for(int j=i+1; j<N; j++){
                boolean nextFlag = ((state&1<<j)>0);
                if(!(flag^nextFlag)){
                    if(flag) link += chemistry[i][j]+chemistry[j][i];
                    else start += chemistry[i][j]+chemistry[j][i];
                }
            }
        }
        return Math.abs(link-start);
    }



}