import java.io.*;
import java.util.*;
// 블로그 참조 https://lovelyunsh.tistory.com/116

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, TreeMap> map = new TreeMap<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            TreeMap cur = map;

            while (K-- > 0) {
                String fruit = st.nextToken();

                if (!cur.containsKey(fruit))
                    cur.put(fruit, new TreeMap<>());
                cur = (TreeMap) cur.get(fruit);
            }
        }

        print(map, 0);
        System.out.println(sb);
    }

    public static void print(TreeMap map, int depth) {
        for (Object node : map.keySet()) {
            for (int i = 0; i < depth; i++){ 
                sb.append("--");
            }
            sb.append(node).append("\n");
            print((TreeMap) map.get(node), depth + 1);
        }
    }
}