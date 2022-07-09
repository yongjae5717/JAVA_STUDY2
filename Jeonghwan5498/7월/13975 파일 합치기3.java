import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++ ){

            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pQ = new PriorityQueue<>();

            for(int j = 0; j < k; j++){
                pQ.add(Long.parseLong(st.nextToken()));
            }

            Long answer = (long)0;
            while(pQ.size() > 1){
                Long next = pQ.poll() + pQ.poll();
                answer += next;
                pQ.add(next);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}