/* 헤매는 중... */

import java.io.*;
import java.util.*;

public class Main {
    
    static class Coordinate {
        
        int x, y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    
    static int r, c, n;
    static int[] height;
    static boolean[][] cave, visited;
    static Queue<Coordinate> queue;
    static ArrayList<Coordinate> cluster;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cave = new boolean[r][c];
        
        // 미네랄 위치 초기화
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                if (str.charAt(j) == 'x') {
                    cave[i][j] = true;
                }
            }
        }
        
        n = Integer.parseInt(br.readLine());
        height = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        
        // 막대 던지기
        int direction = 1;
        for (int i = 0; i < n; i++) {
            
            if (direction == 1) {
                for (int j = 0; j < c; j++) {
                    if (cave[r - height[i]][j]) {
                        cave[r - height[i]][j] = false;
                        bfs(r - height[i], j);
                        // 클러스터를 아래로 몇 칸 옮길 수 있는지
                        int size = getSize();
                        // 클러스터를 아래로 옮기기
                        if (size > 0) {
                            downCluster(size);
                        }
                        break;
                    }
                }
            }
            
            if (direction == -1) {
                for (int j = c - 1; j >= 0; j--) {
                    if (cave[r - height[i]][j]) {
                        cave[r - height[i]][j] = false;
                        bfs(r - height[i], j);
                        // 클러스터를 아래로 몇 칸 옮길 수 있는지
                        int size = getSize();
                        // 클러스터를 아래로 옮기기
                        if (size > 0) {
                            downCluster(size);
                        }
                        break;
                    }
                }
            }
            
            direction *= -1;
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cave[i][j]) {
                    System.out.print('x');
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }
        
    }
    
    private static void downCluster(int size) {
        for (Coordinate coordinate : cluster) {
            cave[coordinate.x][coordinate.y] = false;
            cave[coordinate.x + size][coordinate.y] = true;
        }
    }
    
    private static int getSize() {
        
        int[] rowLocation = new int[c];
        Arrays.fill(rowLocation, -1);
        for (Coordinate coordinate : cluster) {
            if (coordinate.x > rowLocation[coordinate.y]) {
                rowLocation[coordinate.y] = coordinate.x;
            }
        }
        
        int cnt = 1;
        for (int i = 0; i < c; i++) {
            if (rowLocation[i] == -1) {
                continue;
            }
            
            if (rowLocation[i] + cnt < r && cave[rowLocation[i] + cnt][i]) {
                return cnt - 1;
            }
        }
        
        return 0;
    }
    
    private static void bfs(int x, int y) {
        queue = new LinkedList<>();
        cluster = new ArrayList<>();
        visited = new boolean[r][c];
        visited[x][y] = true;
        queue.add(new Coordinate(x, y));
        while (!queue.isEmpty()) {
            int curX = queue.peek().x;
            int curY = queue.poll().y;
            
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if (nextX >= r || nextX < 0 || nextY >= c || nextY < 0) {
                    continue;
                }
                
                if (visited[nextX][nextY]) {
                    continue;
                }
                
                if (!cave[nextX][nextY]) {
                    continue;
                }
                
                visited[nextX][nextY] = true;
                queue.add(new Coordinate(nextX, nextY));
                if (!cluster.contains(new Coordinate(nextX, nextY))) {
                    cluster.add(new Coordinate(nextX, nextY));
                }
            }
        }
    }
}