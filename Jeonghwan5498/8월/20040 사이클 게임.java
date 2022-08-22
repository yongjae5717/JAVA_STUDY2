import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // Union-find 자료구조 초기화
        parent = new int[N];
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        answer = 0;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(find(a) == find(b)){
                answer = i;
                break;
            }
            union(a, b);
        }
        System.out.println(answer);
    }
    public static int find(int a){
        if(parent[a] == a){
            return a;
        }
        else{
            return find(parent[a]);
        }
    }

    public static void union(int a, int b){
        int fA = find(a);
        int fB = find(b);
        if(fA != fB){
            parent[fB] = fA;
        }
    }
}



