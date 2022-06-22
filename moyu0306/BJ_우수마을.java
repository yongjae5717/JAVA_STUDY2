import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] pop;
    static boolean[] visited;
    static ArrayList<Integer>[] adjList;
    static int DP[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pop = new int[N+1];
        visited = new boolean[N+1];
        adjList = new ArrayList[N+1];
        DP = new int[N+1][2];
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        for(int i=1; i<N+1; i++){
            pop[i] = Integer.parseInt(stk.nextToken());
            adjList[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            String[] node = br.readLine().split(" ");
            int a = Integer.parseInt(node[0]);
            int b = Integer.parseInt(node[1]);
            adjList[a].add(b);
            adjList[b].add(a);
        }

      int answer = Integer.max(getMaxPop(0,1,false,true),getMaxPop(0,1,false,false));

        System.out.println(answer);
    }


    public static int getMaxPop (int parent, int current,boolean parentHasChosen, boolean isChosen){
        int num = (isChosen) ? 1 : 0;
        if(DP[current][num] != 0) return DP[current][num];
        int val= num * pop[current];
        for(int node :adjList[current]){
            if(node == parent) continue;
            if(isChosen){
                val += getMaxPop(current,node, true,false);
            }else{
                val += Integer.max(getMaxPop(current,node,false,true),getMaxPop(current,node,false,false));
            }
        }
        return DP[current][num] = val;
    }
}