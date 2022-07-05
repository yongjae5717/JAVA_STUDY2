package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14725_개미굴 {    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Trie root = new Trie();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            root.insert(input);
        }
        root.print(root, 0);
    }

    static class Trie{
        Map<String, Trie> child = new HashMap<>();

        public Trie() { }

        void insert(String[] s) {
            Trie node = this;
            for (int i = 1; i < s.length; i++) {
                node.child.putIfAbsent(s[i], new Trie());
                node = node.child.get(s[i]);
            }
        }

        //dfs
        void print(Trie node, int floor) {
            Trie current = node;
            if (current.child != null) {
                List<String> keys = new ArrayList<>(current.child.keySet());
                Collections.sort(keys);
                for (String s : keys) {
                    for (int i = 0; i < floor; i++) {
                        System.out.print("--");
                    }
                    System.out.println(s);
                    print(current.child.get(s), floor+1);
                }
            }
        }

    }
}
