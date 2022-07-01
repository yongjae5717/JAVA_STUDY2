import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
      public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        ans = new int[3];
        seq = new long[N];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            seq[i] = Long.parseLong(stk.nextToken());
        }

        Arrays.sort(seq);

        for(int i=0; i<N-2; i++){
            setNum(i);
        }

       System.out.println(seq[ans[0]]+" "+seq[ans[1]]+" "+seq[ans[2]]);
    }

    public static void setNum(int idx){
        int left = idx+1;
        int right = seq.length-1;
        while(left<right){

            long val = seq[idx]+seq[left]+seq[right];
            long absVal = Math.abs(val);
            if(absSum>absVal){
               absSum = absVal;
               ans[0] = idx;
               ans[1] = left;
               ans[2] = right;
            }

            if(val>0){
                right--;
            }else{
                left++;
            }
        }
    }
}