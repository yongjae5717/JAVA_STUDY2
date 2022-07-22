import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

       static  ArrayList<Integer>[] adjList;
    static  ArrayList<Integer>[] reverseAdjList;
    static boolean[] visited;
    static int N;
       static int M;
       static int[] orderCount;
       static int[] reverseOrderCount;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        int answer = 0;
        String input[] = br.readLine().split(" ");
        N =  Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        adjList = new ArrayList[N+1];
        reverseAdjList = new ArrayList[N+1];
        for(int i=0; i< N+1; i++){
            adjList[i] = new ArrayList<>();
            reverseAdjList[i] = new ArrayList<>();
        }
        orderCount = new int[N+1];
        reverseOrderCount = new int[N+1];
        Arrays.fill(orderCount,-1);
        Arrays.fill(reverseOrderCount,-1);

        for(int i=0; i< M; i++){
            String[] nodes = br.readLine().split(" ");
            int a = Integer.parseInt(nodes[0]);
            int b = Integer.parseInt(nodes[1]);
            adjList[a].add(b);
            reverseAdjList[b].add(a);
        }

        int half = (N +1)/ 2;

        for(int i=1; i< N+1; i++){
            visited = new boolean[100];
            if(getOrder(i)>=half){
                answer ++;
                continue;
            }
            visited = new boolean[100];
            if(getReverseOrder(i)>=half){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static int getOrder(int node){
        if(!visited[node]){
            visited[node] = true;
            int count = 1;
            for(int i :adjList[node]) {
                if(i== node) continue;
                count += getOrder(i);
            }
            return count;
        }

        return 0;
    }

    public static int getReverseOrder(int node){
        if(!visited[node]){
            visited[node] = true;
            int count = 1;
            for(int i : reverseAdjList[node]) {
                if(i == node) continue;
                count += getReverseOrder(i);

            }
            return  count;
        }

        return 0;
    }
}