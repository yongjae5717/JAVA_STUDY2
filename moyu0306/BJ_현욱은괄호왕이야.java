import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String present = br.readLine();
        int maxLength = 0;
        int current = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0; i<N; i++){
            if(present.charAt(i)=='(') st.push(i);
            else{
                st.pop();
                if(!st.isEmpty()) maxLength = Integer.max(maxLength,i - st.peek());
                else st.push(i);
            }
        }

        System.out.println(maxLength);
    }
}