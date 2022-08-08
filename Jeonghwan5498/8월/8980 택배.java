import java.io.*;
import java.util.*;

public class Main {

    public static class Delivery implements Comparable<Delivery>{
        int from;
        int to;
        int num;

        public Delivery(int from, int to, int num) {
            this.from = from;
            this.to = to;
            this.num = num;
        }

        @Override
        public int compareTo(Delivery o) {
            if(to == o.to){
                return from - o.from;
            }
            else{
                return to - o.to;
            }
        }
    }
    static int N, C, M;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마을 수
        C = Integer.parseInt(st.nextToken()); // 용량
        M = Integer.parseInt(br.readLine()); // 박스 정보 수

        Delivery[] delivery = new Delivery[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            delivery[i] = new Delivery(from, to, num);
        }
        Arrays.sort(delivery);

        // i 마을에서 보낼 수 있는 박스 수.
        int[] remain = new int[N];
        for(int i = 1; i < N; i++){
            remain[i] = C;
        }

        int total_num = 0;
        for (int m = 0; m < M; m++) {
            int from = delivery[m].from;
            int to = delivery[m].to;
            int num = delivery[m].num;

            // m번째 택배를 얼마나 보낼 수 있는지 검사
            int sub_remain = Integer.MAX_VALUE;
            for(int i = from; i < to; i++){
                sub_remain = Math.min(sub_remain, remain[i]);
            }
            // m번째 택배를 모두 보낼 수 있다면
            if(sub_remain >= num){
                for(int i = from; i < to; i++){
                    remain[i] -= num;
                }
                total_num += num;
            }
            // m번째 택배를 일부만(sub_remain만큼) 보낼 수 있다면
            else{
                for(int i = from; i < to; i++){
                    remain[i] -= sub_remain;
                }
                total_num += sub_remain;
            }
        }
        System.out.print(total_num);
    }
}

