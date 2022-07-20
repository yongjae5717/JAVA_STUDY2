import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int w, h;
    static ArrayList<int[]> posList;
    static char[][] map;
    static int[][] distMap;
    static int finalDist;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            // w, h 입력받기.
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0) return;

            // map 입력받고, 시작위치 먼지위치 찾기.
            map = new char[h][w];
            posList = new ArrayList<>();
            posList.add(new int[] {0,0});
            for(int i = 0; i < h; i++){
                String temp = br.readLine();
                for(int j = 0; j < w; j++){
                    map[i][j] = temp.charAt(j);
                    if(temp.charAt(j) == 'o'){
                        posList.set(0, new int[] {j, i});
                    }
                    else if(temp.charAt(j) == '*'){
                        posList.add(new int[] {j, i});
                    }
                }
            }

            // 시작위치과 먼지위치들 사이의 최소거리, 각 먼지위치들 사이의 최소거리 찾고 저장.
            distMap = new int[posList.size()][posList.size()];
            boolean impossible = false;
            for(int i = 0; i < posList.size(); i++){
                if(BFS(i) == -1){
                    impossible = true;
                    break;
                }
            }
            // 도달할 수 없는 먼지 위치가 있으면 continue;
            if(impossible){
                System.out.println(-1);
                continue;
            }

            finalDist = Integer.MAX_VALUE;
            int visited = 1;
            int target = (1 << posList.size()) - 1;
            DFS(0, 0, visited, target);
            System.out.println(finalDist);
        }
    }

    public static int BFS(int startIdx){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(posList.get(startIdx));
        boolean[][] visited = new boolean[h][w];

        visited[posList.get(startIdx)[1]][posList.get(startIdx)[0]] = true;
        int dist = -1;

        while(!queue.isEmpty()){

            int size = queue.size();
            dist++;

            for(int s = 0; s < size; s++){
                int[] curPos = queue.poll();
                int cx = curPos[0];
                int cy = curPos[1];

                // 목표 도달
                if(map[cy][cx] == '*'){
                    for(int i = 1; i < posList.size(); i++){
                        if(cx == posList.get(i)[0] && cy == posList.get(i)[1]){
                            distMap[startIdx][i] = dist;
                        }
                    }
                }

                for(int i = 0; i < 4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if(0 <= nx && nx < w && 0 <= ny && ny < h && map[ny][nx] != 'x' && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        for(int i = 1; i < posList.size(); i++){
            if(startIdx != i && distMap[startIdx][i] == 0){
                return -1;
            }
        }
        return 0;
    }

    public static void DFS(int dist, int from, int visited, int target){

        if(visited == target){
            finalDist = Math.min(finalDist, dist);
        }

        for(int i = 1; i < posList.size(); i++){
            if((visited & (1 << i)) == 0){
                // System.out.println("visited : " + Integer.toBinaryString(visited | (1 << i)) + " " + (dist + distMap[from][i]));
                DFS((dist + distMap[from][i]), i,  visited | (1 << i) , target );
            }
        }
    }
}