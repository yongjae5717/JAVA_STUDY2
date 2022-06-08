import java.util.*;    
class Solution {

        PriorityQueue<int[]> pq;
        int max = 1;
        int num = 0;
        ArrayList<int []> placement = new ArrayList<>();
        public int solution(int n, int m, int[][] timetable) {
            pq= new PriorityQueue<>((a,b)->{return a[1]-b[1];});
            Arrays.sort(timetable,(a,b) ->{ return a[0]-b[0];} );
            for(int[] table: timetable){
                while(!pq.isEmpty()){
                    int[] nearest = pq.peek();
                    if(nearest[1] < table[0]) pq.poll();
                    else{
                        pq.offer(table);
                        break;
                    }
                }

                if(pq.isEmpty()) pq.offer(table);
                 num = Integer.max(num,pq.size());
            }
            
            if(num == 1) return 0;
            for(int i= 2*n; i>1; i--){
                placePeople(n,0,0,0,num,i);
                if(max != 1 )break;
            }

            int answer = max;
            return answer;
        }

        public void placePeople(int N, int r,int c, int current, int total, int localMax){
            if (current == total){
                max = Integer.max(localMax,max);
                
                for(int[] places : placement){
                    System.out.println(places[0]+" "+places[1]);
                }
                return;
            }

            placement.add(new int[]{r,c});
            int pos = r*N + c;
            for(int i= pos +1; i<N*N; i++){
                int newR = i/N;
                int newC = i%N;
                boolean flag = true;
                for(int[] placed : placement){
                    int dist = Math.abs(newR - placed[0]) + Math.abs(newC - placed[1]);
                    if(dist< localMax){
                        flag = false;
                        break;
                    }
                }

                if(flag) placePeople(N, newR, newC, current+1, total, localMax);
            }
            placement.remove(placement.size()-1);
        }
    }