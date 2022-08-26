import java.io.*;
import java.util.*;

public class Main {

    static int n, answer;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        check = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if(c == ')' && !stack.isEmpty()){
                check[i] = true;
                check[stack.pop()] = true;
            }
        }

        int answer = 0;
        int trueSection = 0;
        for(int i = 0; i < n; i++){
            if(check[i]){
                trueSection++;
            }
            else{
                answer = Math.max(answer, trueSection);
                trueSection = 0;
            }
        }
        answer = Math.max(answer, trueSection);

        System.out.println(answer);
    }
}



