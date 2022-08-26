import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
            if(stack.size() >= target.length()) {
                boolean flag = true;
                for(int j = 0; j < target.length(); j++) {
                    if(stack.get(stack.size()-1-j) != target.charAt(target.length()-1-j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j = 0; j < target.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        if(sb.toString().equals("")){
            System.out.println("FRULA");
        }
        else{
            System.out.println(sb);
        }
    }
}



