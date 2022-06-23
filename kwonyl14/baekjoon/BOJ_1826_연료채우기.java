package day2206.day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1826_연료채우기 {

    static class Point implements Comparable<Point>{
        int location, oil;

        public Point(int location, int oil) {
            this.location = location;
            this.oil = oil;
        }

        @Override
        public int compareTo(Point o) {
            return this.location - o.location;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            pq.offer(new Point(l, o));
        }

        st = new StringTokenizer(br.readLine());
        int aim = Integer.parseInt(st.nextToken());
        int currOil = Integer.parseInt(st.nextToken());

        int answer = 0;

        PriorityQueue<Integer> fuels = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (currOil < aim) {
            while (!pq.isEmpty() && pq.peek().location <= currOil) {
                fuels.offer(pq.poll().oil);
            }

            if (fuels.isEmpty()) {
                System.out.println(-1);
                return;
            }

            currOil += fuels.poll();
            answer++;
        }

        System.out.println(answer);
    }
}
