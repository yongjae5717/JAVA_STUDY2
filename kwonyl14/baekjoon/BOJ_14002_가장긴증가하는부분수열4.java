import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N];
        int[] seq = new int[N];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && memo[j] + 1 > memo[i]) {
                    memo[i] = memo[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(memo[i], max);
        }
        //가장 긴 수열길이 append
        sb.append(max + "\n");

		
        int[] longestSeq = new int[max];
        int count = 0;
        for (int i = 0; i < N; i++) {
        	
            //가장긴 수열에서 최댓값을 찾아서 저장
            if (memo[i] == max) {
                longestSeq[count++] = seq[i];
                
                //찾은 최댓값에서 최댓값보다 앞에있는 수들 탐색
                for (int j = i; j >= 0; j--) {
                	
                    //값이 더 작고, 순위가 1 낮은 수들만 저장
                    if (seq[j] < seq[i] && memo[i]-1 == memo[j]) {
                        longestSeq[count++] = seq[j];
                        memo[i]--;
                    }
            	}
                //가장 긴 수열 중 아무 수열만 반환하면 되고, 한 수열을 다 뽑아냈으니 탈출
                break;
        	}
        }
        
        //큰수부터 넣었으니 역순으로 append
        for (int i = max-1; i >= 0; i--) {
            sb.append(longestSeq[i] + " ");
        }

        System.out.println(sb);
    }
}