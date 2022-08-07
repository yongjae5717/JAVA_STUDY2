package HoYoon_Lee.bj23039_실전화기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] connections = new boolean[6][6];
        boolean[][] visit = new boolean[6][6];

        for(int i = 0; i < N; i++) {
            int[] connection = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            connections[connection[0]][connection[1]] = true;
            connections[connection[1]][connection[0]] = true;
        }
        br.close();

        if(N == 10){
            System.out.println(-1);
            return;
        }

        int conflicts = 0;
        for(int i = 1; i < 5; i++){
            for(int j = i + 2; j < 6; j++){
                if(j == i + 4) continue;
                if(!connections[i][j]) continue;
                visit[i][j] = true;
                visit[j][i] = true;
                int a = ((j - i == 2? i : j) + 1) % 5;
                for(int b = 1; b < 6; b++)
                    if(b != i && b != j && b != a && !visit[a][b] && connections[a][b]) conflicts++;
            }
        }

        int answer;
        if(conflicts == 5) answer = 2;
        else if(conflicts != 0) answer = 1;
        else answer = 0;

        System.out.println(answer);
    }
}
