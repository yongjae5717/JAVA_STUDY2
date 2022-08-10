package HoYoon_Lee.bj8980_택배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] parcels = new int[N][N + 1];
        int[] freeSpaces = new int[N];
        Arrays.fill(freeSpaces, C);

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            parcels[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        for(int to = 2; to <= N; to++){
            for(int from = 1; from < N; from++){
                int parcel = parcels[from][to];
                if(parcel > freeSpaces[from]) parcel = freeSpaces[from];
                for(int m = from; m < to; m++)
                    freeSpaces[m] -= parcel;
                answer += parcel;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
