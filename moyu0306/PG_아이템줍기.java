import java.util.*;

class Solution {   
    int[] dy = new int[]{-1,1,0,0};
    int[] dx = new int[]{0,0,-1,1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int answer = Integer.MAX_VALUE;

        
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i=0; i<rectangle.length; i++){
            int[] rec = rectangle[i];
            if(isOnRectangle(rec,characterX,characterY)){
                if((characterX== rec[0]||characterX == rec[2])&&characterY == rec[1]||characterY == rec[2]){
                     q.offer(new int[]{characterX,characterY,0, 0,i});
                     q.offer(new int[]{characterX,characterY,1, 0,i});
                     q.offer(new int[]{characterX,characterY,2, 0,i});
                     q.offer(new int[]{characterX,characterY,3, 0,i});
                }else{
                 int dir =setInitialDirection(rec,characterX, characterY);
                 q.offer(new int[]{characterX,characterY,dir, 0,i});
                 q.offer(new int[]{characterX,characterY,dir+1, 0,i});
                 break;
                }
            }
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            boolean flag = false;
            
            if(pos[0] == itemX &&pos[1] == itemY){
                answer = Integer.min(answer,pos[3]);
                continue;
            }
            
            for(int i=0; i<rectangle.length; i++){
                if(i==pos[4]) continue;
                if(isOnRectangle(rectangle[i],pos[0],pos[1])){
                    flag = true;
                    int dir = setNextRecDirection(rectangle[pos[4]],pos[2],pos[0],pos[1]);
                    int posY = pos[1] + dy[dir];
                    int posX = pos[0] + dx[dir];
                    q.offer(new int[]{posX,posY,dir,pos[3]+1,i});
                    break;
                }
            }
            
            
            
            if(isOnPoint(rectangle[pos[4]],pos[0],pos[1])){
                int  dir = (pos[2]/2+1)%2*2;
                int posY = pos[1] +dy[dir];
                int posX = pos[0] + dx[dir];
                if(!isOnRectangle(rectangle[pos[4]],posX,posY)){
                    dir += 1;
                    posY = pos[1] + dy[dir];
                    posX = pos[0] + dx[dir];
                }
                q.offer(new int[]{posX,posY,dir,pos[3]+1,pos[4]});
            }else if(!flag){
                int dir = pos[2];
                int posY = pos[1] + dy[dir];
                int posX = pos[0] + dx[dir];
                q.offer(new int[]{posX, posY,dir,pos[3]+1,pos[4]});
            }
            
            
        }
        
        return answer;
    }
         
    
    public boolean isOnPoint(int[] rec, int X, int Y){
        int c1 = rec[0];
        int r1 = rec[1];
        int c2 = rec[2];
        int r2 = rec[3];
        
        if(X==c1&&(Y == r1||Y==r2)) return true;
        if(X==c2&&(Y == r1||Y==r2)) return true;
        
        return false;
        
    }
    
    public boolean isOnRectangle(int[] rec, int characterX, int characterY){
        int c1 = rec[0];
        int r1 = rec[1];
        int c2 = rec[2];
        int r2 = rec[3];
        
        if((characterY == r1||characterY==r2)&&c1<=characterX&&characterX<=c2) return true;
        if((characterX == c1||characterX==c2)&&r1<=characterY&&characterY<=r2) return true;

        return false;
    }
    
    public int setInitialDirection(int[] rec, int X, int Y){
        int c1 = rec[0];
        int r1 = rec[1];
        int c2 = rec[2];
        int r2 = rec[3];
        
        if(X == c1 || X== c2 )  return 0; 
        else return 2;
    }
    
    public int setNextRecDirection(int[] rec, int dir, int X, int Y){
        int c1 = rec[0];
        int r1 = rec[1];
        int c2 = rec[2];
        int r2 = rec[3];
        
        dir = (((dir+2)%4)/2)*2;
        
        int posX = X + dx[dir];
        int posY = Y + dy[dir];
        
        
        if(c1<=posX&&c2>=posX&&r1<=posY&&posY<=r2) return dir+1;
        else return dir;
        
    } 
}