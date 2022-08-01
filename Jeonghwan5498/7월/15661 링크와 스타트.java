import java.io.*;
import java.util.*;

public class Main {

    static int[][] S;
    static int N, total_ability, min_diff;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        total_ability = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
                total_ability += S[i][j];
            }
        }
        visited = new boolean[1 << N];
        min_diff = Integer.MAX_VALUE;
        DFS(0, 0);
        System.out.println(min_diff);
    }

    public static void DFS(int used, int num){

        if(num == N)
            return;

        int start_ability = 0;
        int link_ability = 0;

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                if((used & (1 << i)) > 0 && (used & (1 << j)) > 0){
                    start_ability += S[i][j];
                    start_ability += S[j][i];
                }
                if((used & (1 << i)) == 0 && (used & (1 << j)) == 0){
                    link_ability += S[i][j];
                    link_ability += S[j][i];
                }
            }
        }
        int diff = Math.abs(start_ability - link_ability);
        min_diff = Math.min(min_diff, diff);

        for(int i = 0; i < N; i++){
            if((used & (1 << i)) == 0 && !visited[used | (1 << i)]){
                DFS(used | (1 << i), num + 1);
                visited[used | (1 << i)] = true;
            }
        }
    }
}
