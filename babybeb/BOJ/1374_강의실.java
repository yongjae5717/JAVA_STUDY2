import java.io.*;
import java.util.*;

public class Main {
    
    private static class Pair implements Comparable<Pair> {
        
        int start;
        int end;
        
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Pair o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        Pair[] schedule = new Pair[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            schedule[i] =
                new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        // 스케줄 정렬
        Arrays.sort(schedule);
        
        // 스케줄 배정
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(schedule[0].end);
        
        for (int i = 1; i < schedule.length; i++) {
            if (priorityQueue.peek() <= schedule[i].start) {
                priorityQueue.poll();
            }
            priorityQueue.add(schedule[i].end);
        }
        System.out.print(priorityQueue.size());
    }
}