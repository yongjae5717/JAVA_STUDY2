import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static boolean[][] visitedSet;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int sum = a + b + c;
        int[] arr = new int[]{a, b, c};
        visitedSet = new boolean[sum+1][sum+1];
        Arrays.sort(arr);
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;

        q.offer(arr);
        visitedSet[a][b] = true;

        while(!q.isEmpty()){
            int[] nums = q.poll();

            if(nums[0]==nums[1]&&nums[1]==nums[2]){
                flag = true;
                break;
            }

            for(int i=0; i<2; i++){
                for(int j = i+1; j<3; j++){
                    int[] cand = new int[3];
                    cand[0] = nums[0];
                    cand[1] = nums[1];
                    cand[2] = nums[2];
                    cand[j]-= cand[i];
                    cand[i]+= cand[i];
                    Arrays.sort(cand);

                    if(visitedSet[cand[0]][cand[1]]) continue;
                    q.offer(cand);
                    visitedSet[cand[0]][cand[1]] = true;
                }
            }

        }

        System.out.println((flag)? 1 : 0);
    }
}