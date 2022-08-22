import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Integer>> relationship = new ArrayList<>();
    static boolean answerExist = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화 및 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            ArrayList<Integer> relation = new ArrayList<>();
            relationship.add(relation);
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relationship.get(a).add(b);
            relationship.get(b).add(a);
        }

        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            ArrayList<Integer> relation = relationship.get(i);
            if(relation.size() > 0){
                visited[i] = true;
                DFS(i, 0);
                visited[i] = false;
                if(answerExist)
                    break;
            }
        }

        int answer = (answerExist)? 1 : 0;
        System.out.println(answer);
    }

    public static void DFS(int cur, int depth){
        if(depth >= 4){
            answerExist = true;
            return;
        }

        for(Integer next : relationship.get(cur)){
            if(!visited[next]){
                visited[next] = true;
                DFS(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}



