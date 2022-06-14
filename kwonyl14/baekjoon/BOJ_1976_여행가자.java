package day220614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {

    static int adjMatrix[][], N, M, parent[];

    static void makeSet() {
        parent = new int[N+1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjMatrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSet();

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i; j++) {
                if (adjMatrix[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int p = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int np = find(Integer.parseInt(st.nextToken()));
            if (p != -1 && p != np) {
                System.out.println("NO");
                return;
            }
            p = np;
        }
        System.out.println("YES");
    }
}
