package studyGroup.july.july10;

import java.util.HashSet;

public class 소수찾기 {

    public static void main(String[] args) {
        String numbers = "1231"; // 18

        System.out.println(solution(numbers));
    }

    static int n;
    static HashSet<Integer> set;
    static char[] store;
    static boolean[] visited;
    static String number;

    public static int solution(String numbers)
    {
        int answer = 0;

        n = numbers.length();
        set = new HashSet<>();

        number = numbers;

        for (int i = 1; i <= n; i++) {
            store = new char[i];
            visited = new boolean[n];
            dfs(0, i);
        }


        for (int one : set) {
            if (check(one)) {
                answer++;
            }
        }

        return answer;

    }

    public static void dfs(int stage, int m)
    {
        if(stage == m)
        {
            String temp = "";
            for(int i = 0; i < m; i++)
            {
                temp += store[i];
            }
            set.add(Integer.parseInt(temp));
            return;
        }



        for(int i = 0; i < n; i++)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                store[stage] = number.charAt(i);
                dfs(stage+1, m);
                visited[i] = false;
            }
        }
    }

    public static boolean check(int one)
    {
        if(one < 2)
        {
            return false;
        }

        for(int i = 2; i*i <= one; i++)
        {
            if(one % i == 0)
            {
                return false;
            }
        }

        return true;
    }




}
