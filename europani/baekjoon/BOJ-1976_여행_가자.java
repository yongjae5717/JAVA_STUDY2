import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] parent, dest;

    static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) parent[a]=b;
        else parent[b]=a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i=1; i <= N; i++) {
            parent[i]=i;
        }

        for (int i=1; i<=N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                if (row[j].equals("1") && find(i) != find(j+1)) {
                    union(i, j+1);
                }
            }
        }

        dest = new int[M];
        String[] row = br.readLine().split(" ");
        for (int i=0; i<M; i++) {
            dest[i]=Integer.parseInt(row[i]);
        }

        System.out.println(check());
    }

    static String check() {
        for (int i=0; i < M-1; i++) {
            if (parent[dest[i]] != parent[dest[i+1]]) {
                return "NO";
            }
        }
        return "YES";
    }
}