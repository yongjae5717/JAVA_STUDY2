package HoYoon_Lee.bj11657_타임머신;

import java.io.*;
import java.util.*;

class Bus{
    int destination;
    long time;

    public Bus(int destination, long time) {
        this.destination = destination;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken(" ")), m = Integer.parseInt(st.nextToken());
        List<Bus>[] buses = new List[n + 1];
        long[] times = new long[n + 1];
        int[] checkCycle = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Queue<Bus> pq = new LinkedList<>();

        for(int i = 0; i <= n; i++)
            buses[i] = new ArrayList<>();
        Arrays.fill(times, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            buses[Integer.parseInt(st.nextToken(" "))].add(new Bus(Integer.parseInt(st.nextToken(" ")), Integer.parseInt(st.nextToken())));
        }
        br.close();

        times[1] = 0;
        pq.offer(new Bus(1, times[1]));

        while (!pq.isEmpty()){
            Bus bus = pq.poll();
            visit[bus.destination] = false;
            for(Bus nb : buses[bus.destination]) {
                if (times[nb.destination] > times[bus.destination] + nb.time) {
                    times[nb.destination] = times[bus.destination] + nb.time;
                    if(!visit[nb.destination]) {
                        checkCycle[nb.destination]++;
                        if (checkCycle[nb.destination] == n) {
                            visit[0] = true;
                            break;
                        }
                        visit[nb.destination] = true;
                        pq.offer(new Bus(nb.destination, times[nb.destination]));
                    }
                }
            }
        }

        if(visit[0]) bw.write("-1");
        else {
            for (int i = 2; i <= n; i++)
                if (times[i] == Integer.MAX_VALUE)
                    bw.write(-1 + "\n");
                else
                    bw.write(times[i] + "\n");
        }
        bw.close();
    }
}