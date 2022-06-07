import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Ball implements Comparable<Ball>{
        int color, size, idx;

        public Ball(int color, int size, int idx) {
            this.color = color;
            this.size = size;
            this.idx = idx;
        }

        @Override
        public int compareTo(Ball o) {
            if (this.size != o.size)
                return this.size - o.size;
            else
                return this.color - o.color;
        }

        @Override
        public String toString() {
            return "Ball{" +
                    "color=" + color +
                    ", size=" + size +
                    ", idx=" + idx +
                    '}';
        }
    }

    static int N;
    static Ball ball[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ball = new Ball[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            ball[i] = new Ball(color, size, i+1);
        }

        Arrays.sort(ball);
//        for (int i = 0; i < N; i++) {
//            System.out.println(ball[i]);
//        }
        int answer[] = new int[N+1];
        int colorSum[] = new int[N+1];
        int sizeSum[] = new int[200001];
        int dupleSizeSum = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            Ball beforeBall = null;
            if (i > 0) beforeBall = ball[i-1];
            Ball nowBall = ball[i];

            if (beforeBall != null &&
                    nowBall.size == beforeBall.size &&
                    nowBall.color == beforeBall.color) {
                dupleSizeSum += nowBall.size;
            }
            else {
                dupleSizeSum = 0;
            }

            answer[nowBall.idx] = sum - colorSum[nowBall.color] - sizeSum[nowBall.size] + dupleSizeSum;
            sum += nowBall.size;
            sizeSum[nowBall.size] += nowBall.size;
            colorSum[nowBall.color] += nowBall.size;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}
