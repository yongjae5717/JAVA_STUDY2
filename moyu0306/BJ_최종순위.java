import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int T;
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        T = Integer.parseInt(br.readLine());
        StringBuffer answerBuffer = new StringBuffer();
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            HashMap<Integer,Ranking> ranks = new HashMap<>();
            StringBuffer sb = new StringBuffer();
            String[] nums = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int num =Integer.parseInt(nums[j]);
                ranks.put(num,new Ranking(num,j,j));
            }
            M = Integer.parseInt(br.readLine());
            for(int k=0; k<M; k++){
                String[] pair = br.readLine().split(" ");
                int num1 = Integer.parseInt(pair[0]);
                int num2 = Integer.parseInt(pair[1]);

                Ranking rank1 = ranks.get(num1);
                Ranking rank2 = ranks.get(num2);

                if(rank1.last<rank2.last){
                    rank1.current++;
                    rank2.current--;
                }else{
                    rank1.current--;
                    rank2.current++;
                }
            }

            Ranking[] rankList =  ranks.values().toArray(new Ranking[ranks.size()]);
            int pre = -1;
            int curr = -1;
            boolean flag = true;
            Arrays.sort(rankList,(a,b)->{return a.current- b.current;});
            for(Ranking rank : rankList){
                pre= curr;
                curr = rank.current;
                if(pre == curr) {
                    flag = false;
                    break;
                }
                sb.append(rank.val).append(" ");
            }

            if(flag){
                answerBuffer.append(sb).append("\n");
            }else{
                answerBuffer.append("IMPOSSIBLE").append("\n");
            }
        }

        System.out.println(answerBuffer);
    }
}

class Ranking{
    int val;
    int last;
    int current;
    public Ranking(int v, int l, int c){
        val = v;
        last = l;
        current = c;
    }
}