import java.util.*;
import java.io.*;

class Main {

    static int N, M, result;
    static int[] parent;
    static boolean[] truth;
    static List<ArrayList<Integer>> parties;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i=1; i <= N; i++) {
            parent[i]=i;
        }
      
        truth = new boolean[N+1];
        parties = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i=0; i < k; i++) {
            int person = Integer.parseInt(st.nextToken());
            truth[person]=true;
        }

        // Union
        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            ArrayList<Integer> sub = new ArrayList<>();
            for (int j=0; j < k; j++) {
                int person = Integer.parseInt(st.nextToken());
                if (sub.size() > 0) {
                    int a = sub.get(0);
                    if (find(a) != find(person)) {
                        union(a, person);
                    }
                    if (truth[a]) truth[person]=true;
                    else if (truth[person]) truth[a]=true;
                }
                sub.add(person);
            }
            parties.add(sub);
        }
    }

    static int find(int x) {
        if (parent[x]!=x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b]=a;
        } else {
            parent[a]=b;
        }  
    }

    static void makeTruth() {
        for (int i=1; i <= N; i++) {
            if (truth[i]) truth[find(i)]=true;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        makeTruth();
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(truth));
        System.out.println(parties);

        for(int i=0; i<M; i++) {
            if(parties.get(i).size() > 0) {
                if(!truth[find(parties.get(i).get(0))]) result++;
            }
        }

        System.out.println(result);
    }
}