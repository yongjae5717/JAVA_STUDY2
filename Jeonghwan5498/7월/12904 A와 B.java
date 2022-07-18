import java.util.*;
import java.io.*;

public class Main {

    static String S, T;
    static int isPossible;

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = br.readLine();
        T = br.readLine();
        isPossible = 0;
        BFS();
        System.out.println(isPossible);
    }

    public static void BFS(){

        Queue<String> queue = new LinkedList<>();
        queue.offer(T);

        while(!queue.isEmpty()){
            String cur = queue.poll();

            if(cur.equals(S)){
                isPossible = 1;
                return;
            }
            if(cur.length() < S.length()){
                return;
            }

            StringBuilder sb = new StringBuilder(cur);

            if(cur.charAt(cur.length()-1) == 'A')
                sb.deleteCharAt(cur.length()-1);

            else if(cur.charAt(cur.length()-1) == 'B'){
                sb.deleteCharAt(cur.length()-1);
                sb.reverse();
            }
            queue.add(sb.toString());
        }
    }
}