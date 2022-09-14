import java.io.*;
import java.util.*;

public class Main {

    static ArrayDeque<Integer> dq;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            // 함수 p 입력받기.
            String p = br.readLine();
            // 배열에 들어있는 수의 개수 n 입력받기.
            int n = Integer.parseInt(br.readLine());
            // 배열 입력받기.
            String input = br.readLine();

            // n이 0일 때 예외처리
            if(n == 0){
                if(p.contains("D")){
                    bw.write("error\n");
                    continue;
                }
                else{
                    bw.write("[]\n");
                    continue;
                }
            }

            // 배열 처리.
            input = input.substring(1,input.length()-1);
            int[] arr = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

            // 배열 deque에 저장하기.
            dq = new ArrayDeque<>();
            for(Integer a : arr){
                dq.add(a);
            }
            bw.write(AC(p) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static StringBuilder AC(String p){
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);

            if(c == 'R'){
                flag = (flag + 1) % 2;
            }
            else if(c == 'D'){
                if(dq.size() == 0){
                    sb.append("error");
                    return sb;
                }
                if(flag == 0){
                    dq.pollFirst();
                }
                else if(flag == 1){
                    dq.pollLast();
                }
            }
        }

        sb.append("[");
        if(flag == 0){
            while(dq.size() > 1){
                sb.append(Integer.toString(dq.pollFirst()) + ",");
            }
            if(dq.size() == 1){
                sb.append(Integer.toString(dq.pollFirst()));
            }
        }
        else if(flag == 1){
            while(dq.size() > 1){
                sb.append(Integer.toString(dq.pollLast()) + ",");
            }
            if(dq.size() == 1){
                sb.append(Integer.toString(dq.pollLast()));
            }
        }
        sb.append("]");

        return sb;
    }
}



