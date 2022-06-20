import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer,Integer> map;
    static int[] stack;
    static int[] seq;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        stack = new int[N];
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int top = -1;
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<N; i++){
            int num = Integer.parseInt(stk.nextToken());
            seq[i] = num;
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int i= N-1; i>=0; i--){
            int current= seq[i];
            while(top!=-1){
               int cand =  map.get(stack[top]);
               if(cand<=map.get(current)){
                   --top;
               }else{
                   seq[i] = stack[top];
                   break;
               }
            }
            if(top == -1) seq[i] = -1;
            top++;
            stack[top] = current;
        }

        for(int i=0; i<N; i++){
            sb.append(seq[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}