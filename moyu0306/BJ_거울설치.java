import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int min;
    static char[][] map;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static boolean[][][] visited;
    static int startX = 0;
    static int startY = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = 2500;
        map = new char[N][N];
        visited = new boolean[N][N][4];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                if(map[i][j]=='#'){
                    startX = j;
                    startY = i;
                }
            }
        }
        for(int i=0; i<4; i++) move(i,startY, startX,0);
        System.out.println(min);

    }
    public static void move(int dir,int y, int x, int count) {
        int posY = y;
        int posX = x;
        if(count>min) return;


        while(true){
            posY += dy[dir];
            posX += dx[dir];
            if(posY<0||posX<0||posX>=N||posY>=N||map[posY][posX] == '*'||visited[posY][posX][dir]) break;
            else if(map[posY][posX]=='!'){
                visited[posY][posX][dir] = true;
                if(dir == 0 ||dir == 1){
                    move(2,posY,posX,count+1);
                    move(3,posY,posX,count+1);
                }else{
                    move(0,posY,posX,count+1);
                    move(1,posY,posX,count+1);
                }
                visited[posY][posX][dir] = false;

            }else if(map[posY][posX]=='#'){
                if(posY != startY &&posX != startX) min = Integer.min(min, count);
                break;
            }
        }
    }
}