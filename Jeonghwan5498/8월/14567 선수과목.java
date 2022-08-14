import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[] inDegree, answer;
    static boolean[] visited;
    static ArrayList<Integer>[] prerequisite;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prerequisite = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            prerequisite[i] = new ArrayList<>();
        }

        inDegree = new int[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            prerequisite[before].add(after);
            inDegree[after]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int depth = 1;
        answer = new int[N+1];
        visited = new boolean[N+1];

        while(true){
            int S = queue.size();
            for(int s = 0; s < S; s++){
                int cur = queue.poll();
                for(Integer next : prerequisite[cur]){
                    inDegree[next] -= 1;
                }
            }

            for(int i = 1; i <= N; i++){
                if(inDegree[i] == 0 && !visited[i]){
                    queue.add(i);
                    answer[i] = depth;
                    visited[i] = true;
                }
            }
            depth++;

            if(queue.isEmpty())
                break;
        }

        for(int i = 1; i < N; i++){
            System.out.print(answer[i] + " ");
        }
        System.out.print(answer[N]);
    }
}




