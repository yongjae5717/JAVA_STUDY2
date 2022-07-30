package studyGroup.july.july28;


import java.util.*;


public class 위장 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear" }, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }


    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        int n = clothes.length;

        for(int i = 0; i < n; i++)
        {
            String pro = clothes[i][0];
            String category = clothes[i][1];

            map.put(category, map.getOrDefault(category,0) + 1);
        }

        // 경우의 수를 헤아린다.
        // 헤드기어가 2개 있으면 경우의 수는 3개 : 쓰지않음, 1번씀, 2번씀

        for(String key : map.keySet())
        {
            answer = answer * (map.get(key)+1);
        }

        answer -= 1;




        return answer;
    }

}
