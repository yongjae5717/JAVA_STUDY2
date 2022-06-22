import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[][] station;
    static PriorityQueue<Integer> pq;
    static int dest;
    static int givenFuel;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        station = new int[N+2][2];
        for(int i=1; i<N+2; i++){
            String[] input = br.readLine().split(" ");
            station[i][0] = Integer.parseInt(input[0]);
            station[i][1] = Integer.parseInt(input[1]);
        }
        dest = station[N+1][0];
        givenFuel = station[N+1][1];
        int currIdx = 1;
        int count = 0;
        Arrays.sort(station,(a,b)->{return a[0]- b[0];});
        pq = new PriorityQueue<Integer>((a,b) -> {return -a.intValue()+b.intValue();});

        while(givenFuel<dest) {
            for(;currIdx<N+1; currIdx++){
                if(station[currIdx][0]<=givenFuel) pq.offer(station[currIdx][1]);
                else break;
            }
            if(!pq.isEmpty()){
                givenFuel += pq.poll();
                count++;
            }else{
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}