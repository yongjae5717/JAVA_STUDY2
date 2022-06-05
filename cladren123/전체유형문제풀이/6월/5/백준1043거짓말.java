package studyGroup.June.june5;

import java.util.*;
import java.lang.*;
import java.io.*;

/*

유니온 파인드

유니온 파인드를 통해 진실을 아는 사람의 그룹을 만든다.
파티의 멤버들 중 진실을 아는 사람이 한 명도 없다면 answer++

반례
8 4
1 1
3 1 2 3
3 4 5 6
3 6 7 8
2 3 8

정답 : 0

https://sohee-dev.tistory.com/75

 */

public class 백준1043거짓말 {

    static int n, m; // 사람 수, 파티 수
    static boolean[] know;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> party;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());



        // 유니온 파인드 초기화화
       parent = new int[n+1];
        for(int i = 1; i < n+1; i++)
        {
            parent[i] = i;
        }

        // 진실을 아는 사람
        know = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        int knowNumber = Integer.parseInt(st.nextToken());

        for(int i = 0; i < knowNumber; i++)
        {
            int human = Integer.parseInt(st.nextToken());
            know[human] = true;
        }

        // 파티 정보
        party = new ArrayList<>();
        int value, pre = 0;
        for(int i = 0; i < m; i++)
        {
            ArrayList<Integer> partyPeople = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyNumber = Integer.parseInt(st.nextToken());

            if(partyNumber > 0)
            {
                pre = Integer.parseInt(st.nextToken());
                partyPeople.add(pre);
            }
            for(int j = 1; j < partyNumber; j++)
            {
                value = Integer.parseInt(st.nextToken());
                partyPeople.add(value);
                union(pre, value);
                pre = value;
            }
            party.add(partyPeople);
        }

        for(int i = 1; i < n+1; i++)
        {
            if(know[i])
            {
                know[find(i)] = true;
            }
        }

        // 5. 진실을 아는 사람들과 파티를 같이 하지 않았으면 total++
        int parentNum = 0;
        int answer = 0;

        for(int i=0; i<m; i++) {
            if(party.get(i).size() > 0) {
                parentNum = find(party.get(i).get(0));
                if(!know[parentNum]) answer++;
            }
        }

        // 6. 거짓말 할 수 있는 파티 최대 수 출력
        System.out.println(answer);

        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(know));


    }

    static int find(int x)
    {
        if(parent[x] == x)
        {
            return x;
        }
        return find(parent[x]);
    }

    // b의 parent로 a를 변경
    static boolean union(int a, int b)
    {
        a = find(a);
        b = find(b);

        if(a != b)
        {
            if(a>b)
            {
                parent[a] = b;
            }
            else
            {
                parent[b] = a;
            }
            return true;
        }
        return false;
    }

}
