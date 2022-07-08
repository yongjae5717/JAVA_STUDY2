package HoYoon_Lee.bj1374_강의실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> starts = new PriorityQueue<>();
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        int max = 0;

        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            starts.offer(Integer.parseInt(st.nextToken()));
            ends.offer(Integer.parseInt(st.nextToken()));
        }

        br.close();

        int cnt = 0;
        while (!starts.isEmpty()){
            if(starts.peek() < ends.peek()){
                starts.poll();
                max = Math.max(max, ++cnt);
            } else{
                ends.poll();
                cnt--;
            }
        }

        System.out.println(max);
    }
}
