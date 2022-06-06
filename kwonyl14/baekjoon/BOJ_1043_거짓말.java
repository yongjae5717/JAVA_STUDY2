package day2206.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {

    static int N, M;
    static boolean known[];
    static Queue<ArrayList<Integer>> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        known = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        for (int i = 0; i < size; i++) {
            known[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            queue.offer(list);
        }

        while (true) {
            boolean isEnd = true;
            int s = queue.size();
            Loop:
            while (s --> 0) {
                ArrayList<Integer> list = queue.poll();
                for (int n : list) {
                    if (known[n]) {
                        isEnd = false;
                        for (int now : list) {
                            known[now] = true;
                        }
                        continue Loop;
                    }
                }
                queue.offer(list);
            }

            if (isEnd) break;
        }

        System.out.println(queue.size());
    }
}
