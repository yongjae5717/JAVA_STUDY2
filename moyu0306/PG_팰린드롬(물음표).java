import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int M;
    static int[] seq;
    static int[][] DP;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        DP = new int[N][2];
        for(int i=0; i<N; i++) Arrays.fill(DP[i],-1);
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            seq[i] = Integer.parseInt(stk.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<M; i++){
            String[] nums = br.readLine().split(" ");
            int S = Integer.parseInt(nums[0]) -1;
            int E = Integer.parseInt(nums[1]) -1;
            sb.append(isPalindrome(S,E) ? 1 : 0).append("\n");
        }

        System.out.println(sb);

    }

    public static  boolean isPalindrome(int S, int E){
        int type = (S+E)%2;
        int mid = (S+E)/2;
        int length = mid - S+1;

        if(DP[mid][type] == -1){
            int left = mid;
            int right = (type == 0) ? mid : mid+1;
            int palindromeLength = 0;
            for(int i = 0; i<N; i++){
                if(left-i<0||right+i>=N) break;

                if(seq[left-i] == seq[right+i]){
                    palindromeLength = i+1;
                }else break;
            }

            DP[mid][type] = palindromeLength;
        }
        if(DP[mid][type]>=length) return true;
        else return false;


    }
}