import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        if(N == 10){
            System.out.println(-1);
            return;
        }

        boolean[][] edge = new boolean[6][6];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            edge[a][b] = true;
        }

        int conflict = 0;
        for (int i = 1; i <= 4; i++){
            for (int j = i+1; j <= 5; j++){

                // 연결되지 않은 엣지는 고려x
                if(!edge[i][j])
                    continue;

                // 바깥 엣지는 고려x
                if(i+1 == j || (i == 1 && j == 5))
                    continue;

                for (int a = i + 1; a <= 4; a++){
                    for (int b = a+1; b <= 5; b++) {
                        if(a != i && a != j && b != i && b != j && a+1 != b && !(a == 1 && b == 5) && edge[a][b]){
                            conflict++;
                        }
                    }
                }
            }
        }

        int answer = 0;
        if(conflict > 0 && conflict < 5)
            answer = 1;
        else if(conflict == 5)
            answer = 2;

        System.out.println(answer);
    }
}
