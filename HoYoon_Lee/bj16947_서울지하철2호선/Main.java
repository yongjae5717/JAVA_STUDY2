package HoYoon_Lee.bj16947_서울지하철2호선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer>[] platforms;
    private static boolean[] isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        platforms = new List[N + 1];
        isCycle = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
            platforms[i] = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int[] connect = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            platforms[connect[0]].add(connect[1]);
            platforms[connect[1]].add(connect[0]);
        }

        for(int i = 1; i <= N; i++)
            if(findCycle(i, i, i)) break;

        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(isCycle[i]) answer.add(0);
            else answer.add(getMinDistanceToCycle(i, i));
        }

        System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        br.close();
    }

    private static boolean findCycle(int pNum, int prev, int start){
        isCycle[pNum] = true;
        for(int next : platforms[pNum])
            if((next != prev && next == start) || (!isCycle[next] && findCycle(next, pNum, start)))
                return true;
        isCycle[pNum] = false;
        return false;
    }

    private static Integer getMinDistanceToCycle(int pNum, int prev) {
        int min = Integer.MAX_VALUE - 1;
        for (int next : platforms[pNum]){
            if(isCycle[next]) return 1;
            if(next != prev) min = Math.min(min, getMinDistanceToCycle(next, pNum));
        }
        return min + 1;
    }
}
