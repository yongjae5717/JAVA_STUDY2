import java.io.*;
import java.util.*;

public class Main {

    static int T, F;
    static HashMap<String, Integer> hm;
    static int[] parent, num;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while(T-- > 0){

            F = Integer.parseInt(br.readLine());
            parent = new int[2*F+1];
            num = new int[2*F+1];
            for(int i = 1; i <= 2*F; i++){
                parent[i] = i;
                num[i] = 1;
            }

            hm = new HashMap<>();
            int idx = 1;
            for(int f = 0; f < F; f++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!hm.containsKey(a)){
                    hm.put(a, idx++);
                }
                if(!hm.containsKey(b)){
                    hm.put(b, idx++);
                }
                bw.write(union(hm.get(a), hm.get(b)) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }
        else{
            return find(parent[a]);
        }
    }

    public static int union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
            num[a] += num[b];
        }
        return num[a];
    }
}



