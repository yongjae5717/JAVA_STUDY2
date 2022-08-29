import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int t, f;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        
        t = parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            f = parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();
            parent = new int[200000];
            
            for (int j = 0; j < f; j++) {
                st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();
                if (!hashMap.containsKey(first)) {
                    hashMap.put(first, hashMap.size());
                    makeSet(hashMap.get(first));
                }
                if (!hashMap.containsKey(second)) {
                    hashMap.put(second, hashMap.size());
                    makeSet(hashMap.get(second));
                }
                
                unionSet(hashMap.get(first), hashMap.get(second));
                sb.append(-parent[findSet(hashMap.get(first))] + "\n");
            }
        }
        
        System.out.print(sb.toString());
    }
    
    private static void unionSet(Integer u, Integer v) {
        int root1 = findSet(u);
        int root2 = findSet(v);
        
        if (root1 == root2) {
            return;
        }
        parent[root1] += parent[root2];
        parent[root2] = root1;
    }
    
    private static int findSet(Integer v) {
        if (parent[v] < 0) {
            return v;
        }
        parent[v] = findSet(parent[v]);
        return parent[v];
    }
    
    private static void makeSet(Integer v) {
        parent[v] = -1;
    }
}