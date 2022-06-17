import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<int[]>st = new Stack<>();
        N= Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<N+1; i++){
            int tower = Integer.parseInt(stk.nextToken());
            while(!st.isEmpty()){
                int[] nextTower = st.peek();
                if(nextTower[0]>tower){
                    sb.append(nextTower[1]);
                    break;
                }
                else if(nextTower[0] == tower){
                    st.pop();
                    sb.append(nextTower[1]);
                    break;
                }else{
                    st.pop();
                }
            }
            if(st.isEmpty()){
                sb.append("0");
            }
            st.push(new int[]{tower,i});

            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}