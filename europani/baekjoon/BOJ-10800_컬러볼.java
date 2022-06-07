import java.util.*;
import java.io.*;

class Main {

    static int N, total;
    static Ball[] balls;
    static int[] result, sum;

    static class Ball implements Comparable<Ball> {
        int num;
        int color;
        int size;

        Ball(int num, int color, int size) {
            this.num = num;
            this.color = color;
            this.size = size;
        }
        @Override
        public int compareTo(Ball b) {
            return this.size - b.size;
        }

        @Override
        public String toString() {
            return "[" + num  +"]" + color + " " + size;
        }
      
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
      
        balls = new Ball[N];
        result = new int[N];
        sum = new int[N+1];
      
        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
        }
    }

    static void pro() {
        for (int i=0, j=0; i < N; i++) {  // j: now보다 작은 볼 위치
            Ball now = balls[i];

            while (balls[j].size < now.size){   // 같은크기
                sum[balls[j].color] += balls[j].size;
                total += balls[j].size;
                j++;
            }
            
            result[now.num] = total - sum[now.color];    // 같은색상
        }
         
    }

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(balls);
        pro();

        for(int r : result) {
            System.out.println(r);
        }
    }
}
