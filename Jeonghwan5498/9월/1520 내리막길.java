import java.io.*;
import java.util.*;

public class Main {

    public static class Point implements Comparable<Point>{
        int num;
        int y;
        int x;

        public Point(int num, int y, int x) {
            this.num = num;
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            return o.num - num;
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M+2][N+2];
        int[][] map = new int[M+2][N+2];

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Point> points = new ArrayList<>();
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                points.add(new Point(map[i][j], i, j));
            }
        }
        Collections.sort(points);

        dp[1][1] = 1;
        for(Point point : points){
            int cy = point.y;
            int cx = point.x;

            for(int i = 0; i < 4; i++){
                int ny = dy[i] + cy;
                int nx = dx[i] + cx;

                if(map[ny][nx] < map[cy][cx]){
                    dp[ny][nx] += dp[cy][cx];
                }
            }
        }
        bw.write(dp[M][N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}



