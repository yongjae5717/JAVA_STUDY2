import java.io.*;
import java.util.*;

public class Main {

    public static class Book implements Comparable<Book>{

        int start;
        int end;

        public Book(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Book o) {
            if(end == o.end){
                return o.start - start;
            }
            else{
                return end - o.end;
            }
        }
    }

    static int n, m, r;
    static int[] items;
    static int[][] dp;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[] check = new boolean[n+1];
            Book[] books = new Book[m];

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                books[i] = new Book(a, b);
            }
            Arrays.sort(books);

            int cnt = 0;
            Arrays.fill(check, true);
            for(int i = 0; i < m; i++){

                int start = books[i].start;
                int end = books[i].end;

                for(int j = start; j <= end; j++) {
                    if(check[j]) {
                        cnt++;
                        check[j] = false;
                        break;
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

