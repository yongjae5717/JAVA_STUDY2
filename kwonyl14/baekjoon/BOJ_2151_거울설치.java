import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main_bj_2151_거울설치 {

	static class Mirror implements Comparable<Mirror>{
		int x;
		int y;
		int cnt;
		int dir;
		public Mirror(int x, int y, int cnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
		@Override
		public int compareTo(Mirror o) {
			return this.cnt-o.cnt;
		}
		
	}
	static int N,initX,initY;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx= {0,-1,0,1};
	static int[] dy= {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		visit=new boolean[N][N][4];
		for(int i=0; i<N; i++) {
			String s=br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='#') {
					initX=i;
					initY=j;
				}
			}
		}
			PriorityQueue<Mirror> q=new PriorityQueue<Mirror>();
			for(int i=0; i<4; i++) {
				
				q.offer(new Mirror(initX,initY,0,i));
			}
			
			while(!q.isEmpty()) {
			
				Mirror m=q.poll();
				int x=m.x;
				int y=m.y;
				int cnt=m.cnt;
				int dir=m.dir;
				if(visit[x][y][dir])continue;
				visit[x][y][dir]=true;
				
				if(map[x][y]=='#' && !(x==initX && y==initY)) {
					System.out.println(m.cnt);
					System.exit(0);
				}
				int nx=x+dx[dir];
				int ny=y+dy[dir];
				if(!isPossible(nx,ny))continue;
				if(map[nx][ny]=='!') {
					int nDir=0;
					//반시계회전
					if(m.dir==0) nDir=3;
					else nDir=m.dir-1;
					q.offer(new Mirror(nx,ny,cnt+1,nDir));
					//시계회전
					if(m.dir==3) nDir=0;
					else nDir=m.dir+1;
					q.offer(new Mirror(nx,ny,m.cnt+1,nDir));
					
					
				}
				//거울 설치 안하고 가기
					q.offer(new Mirror(nx,ny,m.cnt,m.dir));

			}
		}
	private static boolean isPossible(int nx,int ny) {
		if(nx<0||ny<0||nx>=N||ny>=N||
				map[nx][ny]=='*') return false;
		return true;
	}
		
}