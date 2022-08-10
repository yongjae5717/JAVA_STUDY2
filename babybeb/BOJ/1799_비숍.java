import java.io.*;
import java.util.*;

/* 시간 초과. 더 효율적인 방법을 찾아야 한다. 흑백으로 나누어 생각해본다던지 하는... */
public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, max = 0;
    static boolean[][] isOkay;
    static boolean[][] isUsed;
    static int[] result;
    static int[] dx = new int[]{-1, 1, 1, -1};
    static int[] dy = new int[]{1, 1, -1, -1};

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        isOkay = new boolean[n][n];
        isUsed = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    isOkay[i][j] = true;
                }
            }
        }

        func(0);
        
        System.out.print(max);
        br.close();
    }

    static void func(int k) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isOkay[i][j] || isUsed[i][j]) {
                    continue;
                }
                // 말을 잡을 수 있는지 판단하는 코드
                boolean flag = true;
                for (int s = 1; s < n; s++) {
                    for (int l = 0; l < dx.length; l++) {
                        int row = i + s * dx[l];
                        int col = j + s * dy[l];
                        if (row < 0 || col < 0 || row >= n || col >= n) {
                            continue;
                        }
                        if (isUsed[row][col]) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }
                if (flag) {
                    isUsed[i][j] = true;
                    func(k + 1);
                    isUsed[i][j] = false;
                }
            }
        }
        
        if (k > max) {
            max = k;
        }
    }
}