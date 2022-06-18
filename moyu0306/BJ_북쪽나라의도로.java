import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<int[]>[] adjList;
    static int max = 0;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            isVisited = new boolean[10001];
            adjList = new ArrayList[10001];
            for (int i = 0; i < 10001; i++) adjList[i] = new ArrayList<>();
            while ((str = br.readLine()) != null) {
                String[] input = str.split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int dist = Integer.parseInt(input[2]);
                adjList[a].add(new int[]{b, dist});
                adjList[b].add(new int[]{a, dist});
            }
        }catch(Exception e){}
        
        isVisited[1] = true;
        getMaxDistance(1);
        System.out.println(max);
    }

        public static int getMaxDistance(int k){
            int first = 0;
            int second = 0;
            for(int[] node : adjList[k]){
                if(isVisited[node[0]]) continue;
                isVisited[node[0]] = true;
                int dist = node[1]+ getMaxDistance(node[0]);
                if(first == 0 ||dist>first){
                    second = first;
                    first = dist;
                }else if(second == 0 ||dist>second){
                    second = dist;
                }
        }
            if(second!= 0) max = Integer.max(first+second,max);
            else if(first!= 0) max = Integer.max(first,max);

            return first;
    }
}