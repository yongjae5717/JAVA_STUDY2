import java.io.*;
import java.util.*;


public class Main {
	static Queue<Laser> que = new LinkedList<Laser>();
	static char[][] map;
	static int[][] visit;
	static int W,H;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int ey, ex;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visit = new int[H][W];
		
		int first = 1;
	    for (int i = 0; i < H; i++) {
	     	char[] arr = br.readLine().toCharArray();
	        for (int j = 0; j < W; j++) {
	        	map[i][j] = arr[j];
	            if (map[i][j] == 'C') {
	            	if(first == 1) {
	                	que.add(new Laser(i,j));    
	                	first = 0;
	            	}
	            	else {
	            		ey = i;
	            		ex = j;
	            	}
	            }
	        }
	    }
	
		bfs();
		System.out.println(visit[ey][ex] -1 );
	}
	public static void bfs() {
		while(!que.isEmpty()) {
			Laser laser = que.poll();
			for(int d = 0; d < 4; d++) {
				int ny = laser.y + dy[d];
				int nx = laser.x + dx[d];
	
				while(true) {
					if(!isRange(ny, nx)) {
						break;
					}
					if(map[ny][nx] == '*') {
						break;
					}
					if (visit[ny][nx] == 0) { 
						visit[ny][nx] = visit[laser.y][laser.x]+1;
						que.add(new Laser(ny, nx));
		            }
					ny += dy[d]; 
					nx += dx[d];
				}
			}				
		}
	}
	public static boolean isRange(int ny, int nx) {
		if(ny >= 0 && ny < H && nx >= 0 && nx < W) {
			return true;
		}else {
			return false;
		}
		
	}
}

class Laser{
	int y;
	int x;
	Laser(int y, int x){
		this.y =y;
		this.x =x;
	}
}