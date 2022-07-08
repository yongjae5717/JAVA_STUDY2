import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static char[][] map;
    static int totalNum;
    static int min;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        StringBuilder sb = new StringBuilder("");
        while (true) {
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            if(w==0&&h==0) break;
            map = new char[h][w];
            min = Integer.MAX_VALUE;
            int rowStart = -1;
            int colStart = -1;
            totalNum = 0;
            for (int i = 0; i < h; i++) {
                String next = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] =next.charAt(j);
                    if(map[i][j]=='*') totalNum++;
                    if(map[i][j]=='o'){
                        rowStart = i;
                        colStart = j;
                    }
                }
            }
            findNextpoint(rowStart,colStart,0,0,h,w);
            if(min == Integer.MAX_VALUE){
                sb.append(-1);
            }else sb.append(min);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void findNextpoint(int currentRow,int currentCol,int wipedNum, int moveCount,int h, int w){
        boolean[][] visited = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        if(moveCount>min) return;
        if(wipedNum==totalNum){
            min = Integer.min(min,moveCount);
            return;
        }

        q.offer(new int[]{currentRow,currentCol,moveCount});

        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int i=0; i<4; i++){
                int posY = pos[0] + dy[i];
                int posX = pos[1] + dx[i];
                int move = pos[2];
                if(posY<0||posY>=h||posX<0||posX>=w||visited[posY][posX]||map[posY][posX]=='x')continue;
                visited[posY][posX] = true;
                if(map[posY][posX] == '*'){
                    map[posY][posX] = '.';
                    findNextpoint(posY,posX,wipedNum+1,move+1,h,w);
                    map[posY][posX] = '*';
                }
                else{
                    q.offer(new int[]{posY,posX,move+1});
                }
            }
        }

    }
}