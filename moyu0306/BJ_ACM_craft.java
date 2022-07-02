import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
        static ArrayList<ArrayList<Integer>> alist;
        static Queue<Integer> q;
        static int[] fTime;
        static int[] dTime;
        static int[] in;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int num = Integer.parseInt(br.readLine());
        int testcase =0;
        while(testcase<num) {
            String[] infos = br.readLine().split(" ");
            int buildings = Integer.parseInt(infos[0]);
            int end = Integer.parseInt(infos[1]);
            fTime = new int[buildings+1];
            dTime = new int[buildings+1];
            in = new int[buildings+1];
            alist = new ArrayList<>();
            q = new LinkedList<Integer>();
            for(int i=0; i<buildings+1;i++){
                alist.add(new ArrayList<>());
            }

            String[] values = br.readLine().split(" ");
            for(int i=0; i<buildings;i++){
                dTime[i+1] = Integer.parseInt(values[i]);
                Arrays.fill(in,0);
            }

            int count = 0;
            while(count<end){
                String[] info= br.readLine().split(" ");
                int from = Integer.parseInt(info[0]);
                int to = Integer.parseInt(info[1]);
                alist.get(from).add(to);
                in[to]+=1;
                count++;
            }

            for(int i=1; i<buildings+1;i++){
                if(in[i]==0) {q.add(i); fTime[i]=dTime[i];}
            }
           while(!q.isEmpty()){
               int tmp = q.poll();
               for(int i : alist.get(tmp)){
                   int cand = fTime[tmp]+dTime[i];
                   if(fTime[i]<cand) fTime[i] = cand;
                   if(--in[i]==0) q.offer(i);
               }
           }
           int answer = Integer.parseInt(br.readLine());
           System.out.println(fTime[answer]);
           testcase++;
          }
    }

}