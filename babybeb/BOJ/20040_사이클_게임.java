import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        parents = new int[n];

        makeSet();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = parseInt(st.nextToken());
            int second = parseInt(st.nextToken());
            int firstParent = findSet(first);
            if (firstParent == findSet(second)) {
                System.out.print(i);
                return;
            } else {
                unionSet(first, second);
            }
        }

        System.out.print(0);
    }

    private static void unionSet(int parent, int v) {
        parents[findSet(v)] = findSet(parent);
    }

    private static int findSet(int v) {
        if (v == parents[v]) {
            return v;
        }

        parents[v] = findSet(parents[v]);
        return parents[v];
    }

    private static void makeSet() {
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
}