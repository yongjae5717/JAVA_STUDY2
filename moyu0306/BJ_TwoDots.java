import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] count;
    static boolean answer;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        count = new int[N][M];
        answer = false;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    DFS(i,j,map[i][j]);
                }
            }
        }

        System.out.println((answer) ? "Yes" : "No");

    }
    public static void DFS(int Y, int X, char color){
        if(answer) return;

        for(int i=0; i<4; i++){
            int posY = Y + dy[i];
            int posX = X + dx[i];

            if(posY<0||posY>=N||posX<0||posX>=M) continue;
            if(Math.abs(count[posY][posX]-count[Y][X])>=3&&count[posY][posX]!=0){
                answer = true;
                break;
            }else if(count[posY][posX]!=0||map[posY][posX]!=color) continue;
            else{
                count[posY][posX] = count[Y][X]+1;
                visited[posY][posX] = true;
                DFS(posY,posX,color);
                count[posY][posX] = 0;
            }
        }

    }
}