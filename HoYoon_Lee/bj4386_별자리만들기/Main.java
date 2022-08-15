package HoYoon_Lee.bj4386_별자리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Connection implements Comparable<Connection>{
    int to;
    double distance;

    public Connection(int to, double distance) {
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Connection o) {
        return this.distance >= o.distance? 1 : -1;
    }
}

class Star{
    int number;
    double x, y;
    List<Connection> connections = new ArrayList<>();

    public Star(int number, double x, double y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Star[] stars = new Star[N];
        boolean[] visit = new boolean[N];
        PriorityQueue<Connection> connections  = new PriorityQueue<>();

        double answer = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i] = new Star(i, Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
            for(int j = 0; j < i; j++){
                double distance = Math.sqrt(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2));
                stars[i].connections.add(new Connection(j, distance));
                stars[j].connections.add(new Connection(i, distance));
            }

        }
        br.close();

        connections.addAll(stars[0].connections);
        visit[0] = true;

        while (!connections.isEmpty()){
            Connection connection = connections.poll();
            if(visit[connection.to]) continue;
            visit[connection.to] = true;
            answer += connection.distance;
            connections.addAll(stars[connection.to].connections.stream().filter(c -> !visit[c.to]).collect(Collectors.toList()));
        }

        System.out.printf("%.2f%n", answer);
    }
}
