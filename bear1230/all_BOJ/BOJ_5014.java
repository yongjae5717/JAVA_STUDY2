import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D, ans = -1;
    static int[] map;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // F, S, G, U, D
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        if(S == G) { 
            System.out.println(0);
            return;
        }

        map = new int[F + 1]; 
        check = new boolean[F + 1];

        bfs();
        System.out.println((ans == -1) ? "use the stairs" : ans);
    }
    
    public static void bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(S);
        map[S] = 0;
        check[S] = true;

        while(!que.isEmpty()) {
            int now = que.poll();
            int up = now + U;
            int down = now - D;

            if(up == G || down == G) { 
                ans = map[now] + 1;
                return;
            }

            if(up <= F && !check[up]) {
                que.add(up);
                map[up] = map[now] + 1;
                check[up] = true;
            }
            if(1 <= down && !check[down]) {
                que.add(down);
                map[down] = map[now] + 1;
                check[down] = true;
            }
        }
    }
}