import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[] parents;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        parents = new int[N];
        int answer = 0;
        for(int i=0;i<N; i++) parents[i] = i;

        for(int j=1; j<M+1; j++){
            String[] nums = br.readLine().split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            if(isCycle(a,b)){
                answer = j;
                break;
            }
            union(a,b);
        }

        System.out.println(answer);
    }
    public static int find(int a){
        if(parents[a]==a){
           return a;
        }else
            return parents[a] = find(parents[a]);

    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        parents[a] = b;
    }

    public static boolean isCycle(int a, int b){
        return find(a) == find(b);
    }

}