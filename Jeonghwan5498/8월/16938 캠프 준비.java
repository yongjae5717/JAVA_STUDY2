import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R, X, answer;
    static int problem[];

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        problem = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            problem[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(problem);

        answer = 0;
        DFS(0, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int num, int depth, int status) {

        if (depth == N) {
            if(num >= 2){
                int sum = getSum(status);
                int max = getMax(status);
                int min = getMin(status);

                if (sum >= L && sum <= R && max - min >= X) {
                    answer++;
                }
            }
            return;
        }

        DFS(num + 1, depth + 1, status | (1 << depth));
        DFS(num, depth + 1, status);
    }

    public static int getSum(int status) {

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if ((status & (1 << i)) > 0) {
                sum += problem[i];
            }
        }
        return sum;
    }

    public static int getMax(int status) {
        for (int i = N - 1; i >= 0; i--) {
            if ((status & (1 << i)) > 0) {
                return problem[i];
            }
        }
        return 0;
    }

    public static int getMin(int status) {
        for (int i = 0; i < N; i++) {
            if ((status & (1 << i)) > 0) {
                return problem[i];
            }
        }
        return 0;
    }
}



