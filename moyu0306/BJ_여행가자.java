import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static ArrayList<Integer>[] map;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        parent = new int[N+1];
        for(int i=0; i<N+1; i++) map[i] = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for(int j=1; j<N+1; j++){
                if(stk.nextToken().equals("1")) map[i].add(j);
            }
        }

        for(int i=1; i< N+1; i++){
            setParent(i, i);
        }
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int connectedParent = -1;
        boolean flag = true;
        while(stk.hasMoreTokens()){
            int node = Integer.parseInt(stk.nextToken());
            if(connectedParent == -1 ||connectedParent == parent[node]){
                connectedParent = parent[node];
            }else{
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
    public static void setParent(int i, int p){
        if(parent[i]== 0){
            parent[i] = p;
            for(int node :map[i]){
                setParent(node, p);
            }
        }
    }
}