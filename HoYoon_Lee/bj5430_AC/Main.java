package HoYoon_Lee.bj5430_AC;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String ERROR = "error\n";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        MAIN_LOOP:
        while (T-- > 0){
            String[] functions = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            List<String> x = Arrays.stream(br.readLine()
                            .replace("[", "")
                            .replace("]", "")
                            .split(","))
                    .filter(s -> !s.isBlank())
                    .collect(Collectors.toList());
            boolean isReversed = false;

            for(String function : functions){
                switch (function){
                    case "R":
                        isReversed = !isReversed;
                        break;
                    case "D":
                        if(!x.isEmpty()) {
                            int index;
                            if (isReversed) index = x.size() - 1;
                            else index = 0;
                            x.remove(index);
                            break;
                        }
                    default:
                        bw.write(ERROR);
                        continue MAIN_LOOP;
                }
            }
            if(isReversed) Collections.reverse(x);
            bw.write("[" + String.join(",", x) + "]\n");
        }

        br.close();
        bw.close();
    }
}
