import java.util.*;
import java.io.*;

public class Main {

    static int L, C;
    static char[] charArr;
    static HashSet<Character> vowelSet;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        charArr = new char[C];
        for(int i = 0; i < C; i++){
            charArr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(charArr);

        vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        visited = new boolean[C];
        print_combination("", 0);

    }

    public static void print_combination(String subPassword, int idx){

        if(subPassword.length() == L && check(subPassword)){
            System.out.println(subPassword);
            return;
        }

        if(idx == C) return;

        print_combination(subPassword + charArr[idx], idx+1);
        print_combination(subPassword, idx+1);

    }

    public static boolean check(String password){

        int consonant = 0;
        int vowel = 0;

        for(int i = 0; i < password.length(); i++){
            if(vowelSet.contains(password.charAt(i))){
                vowel++;
            }
            else{
                consonant++;
            }
        }
        return vowel >= 1 && consonant >= 2;
    }
}