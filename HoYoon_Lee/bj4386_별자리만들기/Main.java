package HoYoon_Lee.bj4386_별자리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Connection implements Comparable<Connection>{
    int star1;
    int star2;
    double distance;

    public Connection(int star1, int star2, double distance) {
        this.star1 = star1;
        this.star2 = star2;
        this.distance = distance;
    }

    @Override
    public int compareTo(Connection o) {
        return this.distance <= o.distance? -1 : 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[N];
        double[][] stars = new double[N][2];
        PriorityQueue<Connection> pq = new PriorityQueue<>();
        double answer = 0;

        for(int i = 0; i < N; i++) {
            stars[i] = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            for(int j = 0; j < i; j++)
                pq.offer(new Connection(j, i, Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2))));
        }
        br.close();

        while (!pq.isEmpty()){
            Connection connection = pq.poll();
            if(visit[connection.star1] && visit[connection.star2]) continue;
            answer += connection.distance;
            visit[connection.star1] = true;
            visit[connection.star2] = true;
        }

        System.out.println(String.format("%.2f", answer));
    }
}
