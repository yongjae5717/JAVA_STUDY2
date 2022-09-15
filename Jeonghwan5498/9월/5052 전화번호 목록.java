import java.io.*;
import java.util.*;

public class Main {

    static HashSet<String> hs;
    static String[] arr;
    static int n;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            // n 입력받기, 배열 선언 및 입력받기, 해시셋 선언.
            n = Integer.parseInt(br.readLine());
            arr = new String[n];
            for(int i = 0; i < n; i++){
                arr[i] = br.readLine();
            }
            hs = new HashSet<>();

            // 배열 정렬
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }
                    else{
                        return o1.length() - o2.length();
                    }
                }
            });

            String answer = search()? "YES" : "NO";
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean search(){
        for(int i = 0; i < n; i++){
            String str = arr[i];

            for(int j = 1; j <= str.length(); j++){
                if(hs.contains(str.substring(0,j))){
                    return false;
                }
            }
            hs.add(str);
        }
        return true;
    }
}



