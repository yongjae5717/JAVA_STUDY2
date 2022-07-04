package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1030_프렉탈평면 {
    static int s, N, K, R1, R2, C1, C2;
    static int Max;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/BOJ1030_프렉탈평면/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        Max = (int) Math.pow(N, s);

        StringBuilder sb = new StringBuilder();
        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                sb.append(getColor(i, j, Max));
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    static int getColor(int x, int y, int edgeSize) {
        if (edgeSize == 1) {
            return 0;
        }
        int offsetX = x / edgeSize;
        int offsetY = y / edgeSize;

//        int min = edgeSize / N;
//        int max = (edgeSize / N * 2 - 1) * K;
        int middleBlock = edgeSize / N;
        int min = (edgeSize - middleBlock) / 2 ;
        int max = min + K;

        if (x >= min + (edgeSize * offsetX) && x <= max + (edgeSize * offsetX) &&
                y >= min + (edgeSize * offsetY) && y <= max+ (edgeSize * offsetY)) {
            return 1;
        } else {
            return getColor(x, y, edgeSize / N);
        }
    }

}
