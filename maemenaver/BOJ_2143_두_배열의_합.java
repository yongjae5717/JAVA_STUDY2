import java.io.*;
import java.util.*;

// 참고 : https://subbak2.com/m/27
class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer line;

    int T = Integer.parseInt(br.readLine()); // 목표 숫자
    
    int N = Integer.parseInt(br.readLine()); // A배열의 개수
    int[] A = new int[N];
    line = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < N ; i++) {
      A[i] = Integer.parseInt(line.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    int[] B = new int[M];
    line = new StringTokenizer(br.readLine());
    for (int i = 0 ; i < M ; i++) {
      B[i] = Integer.parseInt(line.nextToken());
    }
  }
}