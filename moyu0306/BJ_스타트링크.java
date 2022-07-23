import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static int[] neededButtonClick;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String[] input = br.readLine().split(" ");
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);
        neededButtonClick = new int[F+1];
        Arrays.fill(neededButtonClick,Integer.MAX_VALUE);
        neededButtonClick[G] = 0;
        int[] dy = new int[]{-U,D};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{G,0});

        while(!q.isEmpty()){
            int[] status = q.poll();
            int pos = status[0];
            int moveCount = status[1];

            for(int i=0; i<2; i++){
                int posY = pos + dy[i];

                if(posY<=0||posY>F) continue;
                if(neededButtonClick[posY] > moveCount+1){
                    neededButtonClick[posY] = moveCount+1;
                    q.offer(new int[]{posY,moveCount+1});
                }
            }
        }
        System.out.println((neededButtonClick[S] == Integer.MAX_VALUE) ?  "use the stairs" : neededButtonClick[S]);
    }
}