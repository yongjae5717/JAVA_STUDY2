import java.io.*;
import java.util.*;


class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{

    int start;
    int end;
    double weight;

    public Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (weight < o.weight){
            return 1;
        }
        else
            return -1;
    }
}

public class Main {

    static int N, M;
    static ArrayList<Edge> edgeList;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 우주신의 개수
        M = Integer.parseInt(st.nextToken()); // 이미 연결된 신들과의 통로 개수

        // Union-Find 알고리즘을 위한 parent 배열 초기화.
        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        // 우주신 좌표 입력받기.
        Point[] points = new Point[N+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        // 이미 연결된 신들의 쌍 입력받기.
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 간선 초기화, 오름차순 정렬.
        edgeList = new ArrayList<>();
        for(int i = 1; i < N; i++){
            for(int j = i + 1; j <= N; j++){
                edgeList.add(new Edge(i, j, makeDistance(points[i], points[j])));
            }
        }
        Collections.sort(edgeList, Collections.reverseOrder());

        double total = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            // 사이클 형성하는지 체크
            Edge edge = edgeList.get(i);
            if(find(edge.start) != find(edge.end)){
                // 사이클을 형성하지 않는다면 가중치를 추가
                total += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(String.format("%.2f", total));
    }

    public static double makeDistance(Point A, Point B){
        return Math.sqrt(Math.pow(A.x - B.x, 2) + Math.pow(A.y - B.y, 2));
    }

    public static int find(int a) {
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }
}
