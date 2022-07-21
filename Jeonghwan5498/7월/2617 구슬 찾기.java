import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 초기화
        int[][] arr = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i != j) arr[i][j] = 101;
            }
        }

        // 배열 입력받기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }

        // 플로이드 워셜 알고리즘
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if (i != j) arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        // 자신보다 무거운 구슬 개수, 자신보다 가벼운 구슬 개수를 구하기
        int answer = 0;
        int target = N/2;
        for(int i = 1; i <= N; i++){
            int cnt1 = 0;
            int cnt2 = 0;
            for(int j = 1; j <= N; j++){
                if(i != j && 0 < arr[i][j] && arr[i][j] < 101){
                    cnt1++;
                }
                if(i != j && 0 < arr[j][i] && arr[j][i] < 101){
                    cnt2++;
                }
            }
            // 과반수보다 많다면 체크크
            if(cnt1 > target) answer++;
            if(cnt2 > target) answer++;
        }
        System.out.println(answer);
    }
}