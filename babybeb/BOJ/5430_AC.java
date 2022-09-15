import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t, n;
    static String p;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            func();
        }

        System.out.print(sb.toString());
    }

    private static void func() throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean isReverse = false; // 처음에는 정방향을 바라보는 deque
        p = br.readLine();
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String temp = br.readLine();
        temp = temp.substring(1, temp.length() - 1);
        st = new StringTokenizer(temp, ",");
        for (int j = 0; j < n; j++) {
            deque.addLast(Integer.parseInt(st.nextToken()));
        }

        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == 'R') {
                isReverse = !isReverse;
            } else {
                if (deque.isEmpty()) {
                    sb.append("error\n");
                    return;
                }
                if (isReverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }

        if (isReverse) { // reverse 상태일 경우 deque를 반대 방향으로 출력하기 위해 temp 사용
            Deque<Integer> reverseOutput = new ArrayDeque<>();
            for (Integer e : deque) {
                reverseOutput.addFirst(e);
            }
            deque = reverseOutput;
        }

        sb.append("[");
        for (Integer e : deque) {
            sb.append(e).append(",");
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]\n");
    }
}