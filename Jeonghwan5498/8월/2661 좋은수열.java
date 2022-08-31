import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("");

    }

    public static void dfs(String str){
        if(!check(str)){
            return;
        }
        if(str.length() == N){
            System.out.println(str);
            System.exit(0);
        }
        for(int i = 1; i <= 3; i++){
            dfs(str + i);
        }
    }

    public static boolean check(String str){
        int n = str.length();
        for(int i = 1; n >= 2*i; i++){
            if(str.substring(n-i, n).equals(str.substring(n-2*i,n-i))){
                return false;
            }
        }
        return true;
    }
}



