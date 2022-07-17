import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] distance;
    static boolean[] isCycle;
    static int cycleStart = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        adjList = new ArrayList[N + 1];
        distance = new int[N+1];
        visited = new boolean[N+1];
        isCycle = new boolean[N+1];
        Arrays.fill(distance,10000);
        for (int i = 1; i < N + 1; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            adjList[a].add(b);
            adjList[b].add(a);
        }
        StringBuffer sb = new StringBuffer("");
        setCycle(-1,1);
        for(int i=1; i< N+1; i++){
            sb.append(setDistance(-1,i)).append(" ");
        }
        System.out.println(sb);
    }

    public static boolean setCycle(int pre, int i){
        if(!visited[i]){
            visited[i] = true;
            boolean flag = false;
            for(int node : adjList[i]){
                if(node == pre) continue;
                 boolean val = setCycle(i, node);
                if(node != cycleStart){
                    flag |= val;
                }
            }
            isCycle[i] |= flag;
        }else if(!isCycle[i]){
            cycleStart = i;
            isCycle[i] = true;
            isCycle[pre] = true;
        }
        return isCycle[i];
    }


    public static int setDistance(int pre, int i){
        if(isCycle[i]) return 0;
        else if(distance[i]== 10000){
            for(int node  : adjList[i]){
                if(node == pre) continue;
                int val = setDistance(i,node);
                distance[i] = Integer.min(distance[i],val+1);
            }
        }
        return distance[i];
    }
}