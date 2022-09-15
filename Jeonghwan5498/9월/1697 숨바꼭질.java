import java.io.*;
import java.util.*;

public class Main {

    static int N, K;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[200001];
        Arrays.fill(arr, 200000);
        arr[N] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(N);


        int time = 0;
        boolean find = false;
        while(true){
            time++;

            int s = q.size();
            for(int i = 0; i < s; i++){
                int temp = q.poll();
                if(temp == K){
                    find = true;
                    break;
                }
                if(temp + 1 <= 100000 && arr[temp + 1] > time){
                    arr[temp + 1] = time;
                    q.add(temp + 1);
                    //System.out.println((temp + 1) + " : "+ time);
                }
                if(temp - 1 >= 0 && arr[temp - 1] > time){
                    arr[temp - 1] = time;
                    q.add(temp - 1);
                    //System.out.println((temp - 1) + " : "+ time);
                }
                if(temp * 2 <= 100000 && arr[temp * 2] > time){
                    arr[temp * 2] = time;
                    q.add(temp * 2);
                    //System.out.println((temp * 2) + " : "+ time);
                }
            }
            // System.out.println();
            if(find){
                break;
            }
        }

        bw.write(arr[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}



