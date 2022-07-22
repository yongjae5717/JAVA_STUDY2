import java.util.*;
import java.io.*;

public class Main {

    static int floor, target, up, down;
    static int[] dir;
    static int[] map;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        floor = Integer.parseInt(st.nextToken());
        int current = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = -1 * Integer.parseInt(st.nextToken());

        dir = new int[] {up, down};
        map = new int[floor+1];
        for(int i = 0; i <= floor; i++){
            map[i] = -1;
        }
        BFS(current);

    }

    public static void BFS(int cx){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(cx);
        map[cx] = 0;

        while(!queue.isEmpty()){

            int cur = queue.poll();
            if(cur == target){
                System.out.println(map[target]);
                return;
            }

            for(int i = 0; i < 2; i++){
                int next = cur + dir[i];
                if(1 <= next && next <= floor && map[next] == -1){
                    map[next] = map[cur] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println("use the stairs");
    }
}