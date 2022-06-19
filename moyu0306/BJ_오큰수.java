import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] seq;
    static int[] stack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        seq = new int[N];
        stack = new int[N];
        int top = - 1;
        for (int i = 0; i <N; i++) {
            seq[i] = Integer.parseInt(stk.nextToken());
            while (top!= -1 &&seq[stack[top]]<seq[i]) {
                seq[stack[top]] = seq[i];
                top--;
            }
            stack[++top] = i;
        }
        for(int i=top; i>=0; i--){
            seq[stack[i]] = -1;
        }