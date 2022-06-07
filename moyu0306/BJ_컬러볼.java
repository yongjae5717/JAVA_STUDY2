import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static ArrayList<int[]> ballArray;
    static int[] answer;
    static int[] colorSum;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ballArray = new ArrayList<>();
        answer = new int[N+1];
        colorSum = new int[N+1];
        for(int i=1;i<N+1; i++){
            String[] info = br.readLine().split(" ");
            ballArray.add(new int[]{i,Integer.parseInt(info[0]),Integer.parseInt(info[1])});
        }

        Collections.sort(ballArray,(a,b) -> {return (a[2]==b[2]) ? a[1] - b[1] : a[2]-b[2];});
        int sum = 0;
        int repeatedVal =  -1;
        int cnt = 0;
        int beforeC = -1;
        for( int[] ball: ballArray){
            int idx = ball[0];
            int color = ball[1];
            int size = ball[2];
            
            if(repeatedVal == size){
                cnt++;
            }else{
                repeatedVal = size;
                cnt = 0;
            }
            colorSum[color] += size;
            sum+= size;
            answer[idx] =  sum - colorSum[color] - repeatedVal *cnt;
            if (color== beforeC && size == repeatedVal) 
            beforeC = color;
        }
        
    }
}