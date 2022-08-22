import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static class Pair {
        
        int length, idx;
        
        public Pair(int length, int idx) {
            this.length = length;
            this.idx = idx;
        }
    }
    
    static int n, max;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Pair> list;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    continue;
                }
                
                int curLen = i - stack.pop() + 1;
                while (!list.isEmpty() && list.get(list.size() - 1).idx > i - curLen) {
                    list.remove((list.size() - 1));
                }
                list.add(new Pair(curLen, i));
            }
        }
        
        if (list.isEmpty()) {
            System.out.print(0);
            return;
        }
        
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).idx - list.get(i).length == list.get(i - 1).idx) {
                list.set(i - 1,
                         new Pair(list.get(i - 1).length + list.get(i).length, list.get(i).idx));
            }
        }
        
        for (Pair pair : list) {
            if (pair.length > max) {
                max = pair.length;
            }
        }
        
        System.out.print(max);
    }
}