import java.util.*;
import java.io.*;

public class Main {

    static int W, H, answer;
    static char[][] map;
    static int[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Node startNode, endNode;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visit = new int[H][W];

        for(int h = 0; h < H; h++){
            String temp = br.readLine();
            for(int w = 0; w < W; w++){
                map[h][w] = temp.charAt(w);
                if(map[h][w] == 'C' && startNode == null){
                    startNode = new Node(w, h, 0, -1);
                }
                else if(map[h][w] == 'C' && startNode != null){
                    endNode = new Node(w, h, 0, -1);
                }
            }
        }

        answer = Integer.MAX_VALUE;
        BFS();
        System.out.println(answer);
    }

    public static void BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visit[startNode.y][startNode.x] = 1;

        while(!queue.isEmpty()){

            Node cur = queue.poll();
            if(cur.x == endNode.x && cur.y == endNode.y){
                answer = Math.min(answer, cur.mirror);
            }

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nmirror = cur.mirror;
                int ndir = i;

                if(nx < 0 || nx >= W || ny < 0 || ny >= H || map[ny][nx] == '*')
                    continue;

                if(cur.dir != -1 && cur.dir != ndir){
                    nmirror++;
                }
                
                if(visit[ny][nx] == 0){
                    visit[ny][nx] = nmirror;
                    queue.add(new Node(nx, ny, nmirror, ndir));
                }
                else if(visit[ny][nx] >= nmirror){
                    visit[ny][nx] = nmirror;
                    queue.add(new Node(nx, ny, nmirror, ndir));
                }
            }
        }
    }

    public static class Node{
        public int x;
        public int y;
        public int mirror;
        public int dir;

        public Node(int x, int y, int mirror, int dir) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }
    }
}