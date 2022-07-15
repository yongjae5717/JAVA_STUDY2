package HoYoon_Lee.bj3665_최종순위;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String CANNOT_FIND = "?";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            StringBuilder answer = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            List<Integer>[] nodes = new List[n + 1];
            Map<Integer, Integer> depth = new HashMap<>();
            int[] t = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[t[t.length - 1]] = new ArrayList<>();
            depth.put(t[t.length - 1], n - 1);
            for(int i = t.length - 2; i >= 0; i--) {
                nodes[t[i]] = new ArrayList<>(nodes[t[i + 1]]);
                nodes[t[i]].add(t[i + 1]);
                depth.put(t[i], n - nodes[t[i]].size() - 1);
            }

            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++){
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int forward;
                if(nodes[inputs[0]].contains(inputs[1])) forward = 0;
                else forward = 1;

                nodes[inputs[forward]].remove(Integer.valueOf(inputs[1 - forward]));
                depth.compute(inputs[forward], (k, v) ->  v + 1);
                nodes[inputs[1 - forward]].add(inputs[forward]);
                depth.compute(inputs[1 - forward], (k, v) -> v - 1);
            }

            int cnt = 0;
            Queue<Integer> queue = depth.entrySet().stream()
                    .filter(e -> e.getValue() == 0)
                    .map(Map.Entry::getKey).collect(Collectors.toCollection(LinkedList::new));
            queue.remove(Integer.valueOf(0));
            while (!queue.isEmpty()){
                if(queue.size() > 1){
                    answer = new StringBuilder(CANNOT_FIND);
                    break;
                }
                int team = queue.poll();
                answer.append(team).append(" ");
                for(int next : nodes[team]){
                    depth.compute(next, (k, v) -> v - 1);
                    if(depth.get(next) == 0)
                        queue.add(next);
                }
                cnt++;
            }
            if(cnt != n) answer = new StringBuilder(IMPOSSIBLE);
            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }
}
