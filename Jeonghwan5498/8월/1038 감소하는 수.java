import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Long> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS("", 9, 0);
        Collections.sort(numbers);

        if(N < numbers.size()){
            System.out.println(numbers.get(N));
        }
        else{
            System.out.println(-1);
        }

    }

    public static void DFS(String str, int index, int depth){
        if(index < -1)
            return;

        if(depth >= 10 && !str.equals("")){
            numbers.add(Long.parseLong(str));
            return;
        }
        DFS(str + Integer.toString(index), index - 1, depth + 1);
        DFS(str, index - 1, depth + 1);
    }
}



