package HoYoon_Lee.bj14567_선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Subject{
    int number, cnt;
    List<Subject> next = new ArrayList<>();

    public Subject(int number) {
        this.number = number;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] semester = new int[n + 1];
        Subject[] subjects = new Subject[n + 1];
        Queue<Subject> q;
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i <= n; i++)
            subjects[i] = new Subject(i);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            subjects[a].next.add(subjects[b]);
            subjects[b].cnt++;
        }

        q = Arrays.stream(subjects).filter(s -> s.cnt == 0).collect(Collectors.toCollection(LinkedList::new));

        int s = 1;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0) {
                Subject subject = q.poll();
                semester[subject.number] = s;
                for(Subject ns : subject.next){
                    if(--ns.cnt == 0)
                        q.offer(ns);
                }
            }
            s++;
        }

        for(int i = 1; i <= n; i++)
            answer.append(semester[i]).append(" ");

        System.out.println(answer);
        br.close();
    }
}
