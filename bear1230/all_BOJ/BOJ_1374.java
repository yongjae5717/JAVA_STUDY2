import java.io.*;
import java.util.*;

public class Main {
    static int N = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int ans = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();
        PriorityQueue<Node> que = new PriorityQueue(Comparator.comparingInt(o -> ((Node) o).end));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Node(id, start, end));
        }
        
        Collections.sort(list, Comparator.comparingInt(o -> o.start));
        que.add(list.get(0));
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start >= que.peek().end)
                que.poll();
            else
                ans++;
            que.add(list.get(i));
        }
        System.out.println(ans);
    }
}

class Node {
    int id;
    int start;
    int end;

    Node(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}
