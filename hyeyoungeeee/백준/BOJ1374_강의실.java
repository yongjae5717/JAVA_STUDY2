package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1374_강의실 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> pq = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });
        ArrayList<Lecture> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lecture(id, start, end));
        }
        Collections.sort(list, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int res = N;
        for (Lecture next : list) {
            if (!pq.isEmpty()) {
                Lecture firstEnd = pq.peek();
                if (next.start >= firstEnd.end) {
                    pq.poll();
                    res--;
                }
            }
            pq.add(next);
        }
        System.out.println(res);
    }
    static class Lecture {
        int id;
        int start;
        int end;

        public Lecture(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

    }
}

