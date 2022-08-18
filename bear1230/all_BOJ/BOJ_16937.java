import java.io.*;
import java.util.*;

public class Main {
    static int N,L,R,X;
    static int [] map;
    static int tmp_cnt,tmp_min,tmp_answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i)
        {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        int answer = 0;
        for(int i = 0; i < N-1; ++i)
        {
            tmp_cnt = N-i;
            tmp_min = map[i];
            tmp_answer = 0;
            comb(i+1,1,1,map[i],map[i]);
            answer += tmp_answer;
        }
        System.out.print(answer);
    }
    static void comb(int idx, int cnt,int add_cnt,int max,int tot)
    {
        if(cnt == tmp_cnt)
        {
            if(add_cnt > 1)
            {
                if((max-tmp_min >= X) && (tot >= L && tot <= R)) tmp_answer++;
            }
            return;
        }

        for(int i = idx; i < N; ++i)
        {
            comb(i+1,cnt+1,add_cnt,max,tot);
            comb(i+1,cnt+1,add_cnt+1,map[i],tot+map[i]);
        }

    }
}