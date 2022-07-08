import java.util.*;
import java.io.*;

public class Main {

    public static class course implements Comparable<course>{
        int start;
        int end;

        public course(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(course o){
            return start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        course[] courses = new course[N];

        // course 배열에 강의시간 정보 입력
        for(int i = 0; i < N; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            courses[num-1] = new course(start+1, end);
        }

        // course 배열을 시작시간 기준 오름차순 정렬
        Arrays.sort(courses);

        // course 배열을 순회하며 계산
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0; i < N; i++ ){

            int start = courses[i].start;
            int end = courses[i].end;

            while( !pQ.isEmpty() && pQ.peek() < start){
                pQ.poll();
            }
            pQ.add(end);
            answer = Math.max(answer, pQ.size());
        }
        System.out.println(answer);
    }
}




