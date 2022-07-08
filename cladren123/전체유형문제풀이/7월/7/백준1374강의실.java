package studyGroup.july.july7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준1374강의실 {

    static int n;
    static ArrayList<lecture> lecturelist;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        lecturelist = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lecturelist.add(new lecture(index, start, end));
        }


        // 시작 순서로 정렬
        Collections.sort(lecturelist,  new Comparator<lecture>() {
            @Override
            public int compare(lecture o1, lecture o2)
            {
                return o1.start - o2.start;
            }
        });

        // 빨리 끝나는 강의부터 나오게 정렬
        PriorityQueue<lecture> que = new PriorityQueue<>(new Comparator<lecture>() {
            @Override
            public int compare(lecture o1, lecture o2) {
                return o1.end - o2.end;
            }
        });

//        PriorityQueue<Integer> que = new PriorityQueue<>();

        int answer = 0;


        // 이 부분이 중요했네
        // 비교한다음에 넣어야 했다

        for(int i = 0; i < n; i++)
        {
            while(!que.isEmpty() && que.peek().end <= lecturelist.get(i).start)
            {
                que.poll();
            }

            que.add(lecturelist.get(i));
            answer = Math.max(answer, que.size());
        }




        System.out.println(answer);

    }

    static class lecture
    {
        int index;
        int start;
        int end;

        lecture(int index, int start, int end)
        {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

}
