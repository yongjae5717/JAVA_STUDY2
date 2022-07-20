package HoYoon_Lee.bj1759_암호만들기;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static String[] characters;
    private static final List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        characters = Arrays.stream(br.readLine().split(" ")).sorted().toArray(String[]::new);
        findSecrets(0, L, "");
        bw.write(String.join("\n", answers));

        br.close();
        bw.close();
    }

    private static void findSecrets(int start, int cnt, String secret){
        if(cnt == 0) {
            String[] split = secret.split("");
            if(Arrays.stream(split).anyMatch(s -> s.matches("[aeiou]")) &&
                    Arrays.stream(split).filter(s -> !s.matches("[aeiou]")).count() >= 2)
                answers.add(secret);
            return;
        }

        for(int i = start; i < characters.length; i++){
            findSecrets(i + 1, cnt - 1, secret + characters[i]);
        }
    }
}
