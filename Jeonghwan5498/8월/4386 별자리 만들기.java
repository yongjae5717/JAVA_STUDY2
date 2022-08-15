import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    public static class Line implements Comparable<Line>{
        int toIdx;
        double distance;

        public Line(int toIdx, double distance) {
            this.toIdx = toIdx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Line o) {
            if(distance > o.distance){
                return 1;
            }
            else if(distance < o.distance){
                return -1;
            }
            else{
                return 0;
            }
        }
    }

    public static class Point{
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static double total = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        Point[] pointMap = new Point[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            pointMap[i] = new Point(a, b);
        }

        ArrayList<ArrayList<Line>> lineMap = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Line> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(i != j){
                    temp.add(new Line(j, getDistance(pointMap[i], pointMap[j])));
                }
            }
            lineMap.add(temp);
        }

        PriorityQueue<Line> pQ = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        pQ.add(new Line(0, 0));

        while(!pQ.isEmpty()){
            Line curLine = pQ.poll();

            // pQ의 후보들 중 고르기.
            if(visited[curLine.toIdx])
                continue;
            visited[curLine.toIdx] = true;
            total += curLine.distance;

            // pQ에 후보들 입력하기.
            for(Line nextLine : lineMap.get(curLine.toIdx)){
                if(!visited[nextLine.toIdx]){
                    pQ.add(nextLine);
                }
            }

            if(++count == n)
                break;
        }
        System.out.println(total);
    }

    public static double getDistance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}




