import java.io.*;
import java.util.*;

public class Main {

    static int H, W;
    static boolean[][] block;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new boolean[H][W];

        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < W; j++){
            int temp = Integer.parseInt(st.nextToken());
            for(int i = 0; i < temp; i++){
                block[i][j] = true;
            }
        }

        int total_water = 0;
        for(int i = 0; i < H; i++){

            boolean blocked = false;
            int sum_water = 0;
            int water = 0;

            for(int j = 0; j < W; j++){

                if(block[i][j]){
                    if(blocked){
                        sum_water += water;
                    }
                    blocked = true;
                    water = 0;
                }
                else{
                    water++;
                }
            }
            total_water += sum_water;
        }
        System.out.println(total_water);
    }
}

